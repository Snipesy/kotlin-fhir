/*
 * Copyright 2025-2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getElementName

/**
 * Registry of the consolidated choice-type ("value[x]") option-sets for a single FHIR version.
 *
 * FHIR choice types (e.g. `Patient.deceased[x]` → boolean | dateTime) are modelled as a sealed
 * interface with one permitted subtype per allowed type. The same option-sets recur across hundreds
 * of resources, so instead of regenerating a nested sealed interface (with a wrapper data class per
 * type) per resource, we emit **one shared sealed interface per distinct option-set** and let the
 * member types implement it directly — *bare* — wherever that is type-safe.
 *
 * A member type T is **bare** in a set S (the model type implements S directly, no wrapper) unless
 * either:
 * - T's model type is not a class in the model package (only `integer64` → `kotlin.Long`), or
 * - S contains another member that is an ancestor or descendant of T (FHIR inheritance: `Quantity`
 *   ⊃ Age/Count/Distance/Duration, `String` ⊃ Code/Id/Markdown, `Uri` ⊃ Url/Canonical/Oid/Uuid,
 *   `Integer` ⊃ PositiveInt/UnsignedInt). Two members that are indistinguishable at an `is`-check
 *   would break exhaustiveness, so those are **boxed** in a shared `<Type>Box` data class instead.
 *   This only happens in the ~50-type "open" set and a handful of others.
 *
 * Each resource keeps its API via a nested type alias (e.g. `Observation.Value = …`), and the set
 * interface exposes each member via a nested alias + `asX()` extension. The generated file is
 * produced by [ChoiceTypesFileSpecGenerator]; the same instance is shared with the model and
 * serializer generators so all references resolve consistently.
 */
class ChoiceTypeRegistry
private constructor(
  val packageName: String,
  /** Expansion name (e.g. `Quantity`) → the wrapped model value type (e.g. `…r4.Quantity`). */
  private val modelTypes: Map<String, ClassName>,
  private val setsBySignature: Map<String, ChoiceSet>,
  /** Capitalized type name → its transitive ancestor capitalized names (via `baseDefinition`). */
  private val ancestorsByType: Map<String, Set<String>>,
  /** Simple names of every generated FHIR type — used to detect choice-alias name collisions. */
  val typeNames: Set<String>,
) {
  /** A distinct choice option-set, shared across every element that declares it. */
  data class ChoiceSet(
    val className: ClassName,
    /** Member types in canonical (alphabetical-by-expansion) order. */
    val types: List<Type>,
    /**
     * True when [className] is a compact `Choice<hash>` name (too many members to join). Such names
     * are not meaningful at a field's use-site, but are never surfaced to users.
     */
    val compressed: Boolean,
    /** Dotted paths of the fields this set is the choice type for (e.g. `Observation.value`). */
    val declaringPaths: List<String>,
  )

  /** All distinct option-sets, ordered by interface name for deterministic output. */
  val choiceSets: List<ChoiceSet> = setsBySignature.values.sortedBy { it.className.simpleName }

  /** The shared sealed interface [element] resolves to. */
  fun choiceSetFor(element: Element): ChoiceSet =
    setsBySignature.getValue(signatureOf(element.type!!))

  /**
   * Whether the per-resource nested alias for [element] (named after the field) would shadow a name
   * already in scope — a generated FHIR type (e.g. `DeviceRequest.code[x]` → `Code`) or the
   * enclosing class itself (e.g. `Claim.Diagnosis.diagnosis[x]` → `Diagnosis`). Nested type aliases
   * aren't tracked by KotlinPoet, so it can't qualify around such a clash; the alias is skipped and
   * the property is typed with the shared set directly instead.
   */
  fun aliasNameCollides(element: Element, enclosingClassName: ClassName): Boolean {
    val aliasName = element.getElementName().capitalized()
    return aliasName in typeNames || aliasName == enclosingClassName.simpleName
  }

  /** [element]'s member types in canonical order (the order used everywhere). */
  fun canonicalTypes(element: Element): List<Type> = choiceSetFor(element).types

  /** The model value type for an expansion, e.g. `…r4.Quantity`, or `kotlin.Long` for integer64. */
  fun modelType(expansionName: String): ClassName = modelTypes.getValue(expansionName)

  /** The shared box-type data class for an expansion, e.g. `QuantityBox`. */
  fun wrapperClassName(expansionName: String): ClassName =
    ClassName(packageName, expansionName + WRAPPER_SUFFIX)

  private fun ChoiceSet.contains(expansionName: String): Boolean =
    types.any { choiceTypeExpansionName(it) == expansionName }

  /**
   * Whether [expansionName] is wrapped (vs bare) within [set]: true when its model type cannot be a
   * bare member, or when [set] holds an ancestor/descendant of it. Only meaningful for a member of
   * [set] — callers that aggregate across sets must first check membership via [contains].
   */
  fun isWrapped(set: ChoiceSet, expansionName: String): Boolean {
    if (!isBareable(expansionName)) return true
    val others = set.types.map { choiceTypeExpansionName(it) }.filter { it != expansionName }
    return others.any { other ->
      ancestorsByType[expansionName].orEmpty().contains(other) ||
        ancestorsByType[other].orEmpty().contains(expansionName)
    }
  }

  fun isWrapped(element: Element, type: Type): Boolean =
    isWrapped(choiceSetFor(element), choiceTypeExpansionName(type))

  /** The member type as it appears in [set]: the shared wrapper if wrapped, else the model type. */
  fun memberClassName(set: ChoiceSet, expansionName: String): ClassName =
    if (isWrapped(set, expansionName)) wrapperClassName(expansionName) else modelType(expansionName)

  fun memberClassName(element: Element, type: Type): ClassName =
    memberClassName(choiceSetFor(element), choiceTypeExpansionName(type))

  /** The sets in which the model type named [modelSimpleName] is a **bare** member. */
  fun setsWhereBare(modelSimpleName: String): List<ClassName> =
    choiceSets
      .filter { set ->
        set.types.any { type ->
          val exp = choiceTypeExpansionName(type)
          modelTypes[exp]?.simpleName == modelSimpleName &&
            modelTypes[exp]?.packageName == packageName &&
            !isWrapped(set, exp)
        }
      }
      .map { it.className }

  /** Every expansion that is wrapped in at least one set (needs a `<Type>Box` box class). */
  val wrappedExpansions: List<String> =
    modelTypes.keys
      .filter { exp -> choiceSets.any { it.contains(exp) && isWrapped(it, exp) } }
      .sorted()

  /** The sets a wrapper participates in — i.e. the sets that contain it and wrap it. */
  fun setsWhereWrapped(expansionName: String): List<ClassName> =
    choiceSets
      .filter { it.contains(expansionName) && isWrapped(it, expansionName) }
      .map { it.className }

  /**
   * Model types that are a bare member of two or more option-sets, each mapped to those sets
   * (ordered). Each is collapsed into a single `<Type>Choices` aggregate sealed interface (emitted
   * into `FhirChoiceParticipants.kt` by [ChoiceTypesFileSpecGenerator]) so the model class declares
   * one supertype instead of a long list. Types bare in fewer than two sets are omitted —
   * collapsing gains nothing there.
   */
  val choiceParticipants: Map<ClassName, List<ClassName>> =
    modelTypes.values
      .filter { it.packageName == packageName }
      .distinct()
      .sortedBy { it.simpleName }
      .associateWith { setsWhereBare(it.simpleName) }
      .filterValues { it.size >= 2 }

  /** The `<Type>Choices` aggregate interface a model type's bare memberships collapse into. */
  fun aggregateClassName(modelSimpleName: String): ClassName =
    ClassName(packageName, PARTICIPANTS_OBJECT, modelSimpleName + AGGREGATE_SUFFIX)

  /**
   * The supertypes a model class declares for its bare choice memberships: a single `<Type>Choices`
   * aggregate when it is bare in two or more sets, otherwise the sets directly (zero or one). The
   * aggregate is `sealed` with the model type as its sole subtype, so a `when` over any option-set
   * stays exhaustive (`is DateTime` covers the `DateTimeChoices` branch).
   */
  fun bareSuperinterfacesFor(modelSimpleName: String): List<ClassName> {
    val sets = setsWhereBare(modelSimpleName)
    return if (sets.size >= 2) listOf(aggregateClassName(modelSimpleName)) else sets
  }

  /**
   * KDoc describing the choice as the union of its members (each linked), wrapping long unions
   * across lines. Bare members link the model type; wrapped members link the `<Type>Box` box type.
   * When [includeDeclaringPaths] is set (the shared interface itself), also lists the fields this
   * is the choice type for (e.g. `Observation.value`).
   */
  /** The union KDoc for [element]'s choice type — for the property/parameter that holds it. */
  fun unionDoc(element: Element): CodeBlock = unionDoc(choiceSetFor(element))

  fun unionDoc(set: ChoiceSet, includeDeclaringPaths: Boolean = false): CodeBlock {
    val members =
      set.types.map { type ->
        val exp = choiceTypeExpansionName(type)
        if (isWrapped(set, exp)) wrapperClassName(exp) else modelType(exp)
      }
    val doc = CodeBlock.builder().add("A FHIR choice type — one of:\n")
    var lineLength = 0
    members.forEachIndexed { index, member ->
      if (index > 0) {
        if (lineLength > MAX_DOC_LINE_LENGTH) {
          doc.add(" |\n")
          lineLength = 0
        } else {
          doc.add(" | ")
          lineLength += 3
        }
      }
      doc.add("[%T]", member)
      lineLength += member.simpleName.length + 2
    }
    if (includeDeclaringPaths && set.declaringPaths.isNotEmpty()) {
      doc.add("\n\nThe choice type for:\n")
      val shown = set.declaringPaths.take(MAX_DECLARING_PATHS)
      shown.forEach { doc.add("- `%L`\n", it) }
      val extra = set.declaringPaths.size - shown.size
      if (extra > 0) doc.add("- … and %L more\n", extra)
    }
    return doc.build()
  }

  /** A model type is bare-able only if its model representation is a class in the model package. */
  private fun isBareable(expansionName: String): Boolean =
    modelTypes[expansionName]?.packageName == packageName

  companion object {
    // Box types carry a `Box` suffix (`QuantityBox`) so the nested alias `typealias Quantity =
    // QuantityBox` needs no qualification and `toString()` distinguishes the box from the wrapped
    // model type.
    private const val WRAPPER_SUFFIX = "Box"
    // Per-type aggregate of a model type's bare set memberships, e.g. `DateTimeChoices`. The plural
    // suffix avoids colliding with the singular `…Choice` option-set names.
    private const val AGGREGATE_SUFFIX = "Choices"

    // The choice types and the per-type aggregates are each namespaced under a single object so
    // they
    // don't clutter the model package's top-level namespace. They must remain in this package —
    // sealed subtypes can't cross packages — so an object is the only namespacing device available.
    const val CHOICE_TYPES_OBJECT = "FhirChoiceTypes"
    const val PARTICIPANTS_OBJECT = "FhirChoiceParticipants"
    /** Approximate column at which the union KDoc wraps to the next line. */
    private const val MAX_DOC_LINE_LENGTH = 72

    // A member "Or"-join longer than this is dropped in favour of the first declaring path. Sized
    // so a readable four-member join still wins (e.g. the 55-char
    // `CanonicalOrCodeableConceptOrDataRequirementOrExpression`).
    private const val MAX_JOINED_NAME_LENGTH = 64
    /** Cap on declaring-field paths listed in an interface's KDoc. */
    private const val MAX_DECLARING_PATHS = 20

    private fun signatureOf(types: List<Type>): String =
      types.map { choiceTypeExpansionName(it) }.sorted().joinToString("|")

    fun build(
      packageName: String,
      structureDefinitions: List<StructureDefinition>,
    ): ChoiceTypeRegistry {
      // Package-only mapper: mapTypeToClassName depends solely on the (version) package name.
      val typeMapper =
        PropertyMapper(
          PropertyMapper.MappingContext.MODEL,
          ClassName(packageName, "Choice"),
          emptyMap(),
        )

      val modelTypes = sortedMapOf<String, ClassName>()
      // Insertion order preserved; canonical (sorted-by-expansion) member list per option-set.
      val canonicalTypesBySignature = linkedMapOf<String, List<Type>>()
      // Distinct dotted element paths declaring each option-set (e.g. `Observation.value`) — used
      // both to name a set whose "Or"-join is too long (`ObservationComponentValueChoice`) and to
      // document, in each interface's KDoc, which fields it is the choice type for.
      val pathsBySignature = linkedMapOf<String, MutableSet<String>>()

      structureDefinitions
        .asSequence()
        .flatMap { it.snapshot?.element ?: emptyList() }
        // A multi-type element is a choice type (choice paths normally end in "[x]"). Matches
        // PropertyMapper.getSealedInterfaceType so every set it can request is registered.
        .filter { it.type != null && it.type.size > 1 }
        .forEach { element ->
          val types = element.type!!
          for (type in types) {
            val expansion = choiceTypeExpansionName(type)
            val mapped = typeMapper.mapTypeToClassName(type)
            val previous = modelTypes.put(expansion, mapped)
            require(previous == null || previous == mapped) {
              "Inconsistent model type for choice expansion '$expansion': $previous vs $mapped"
            }
          }
          val signature = signatureOf(types)
          canonicalTypesBySignature.putIfAbsent(
            signature,
            types.sortedBy { choiceTypeExpansionName(it) },
          )
          pathsBySignature
            .getOrPut(signature) { sortedSetOf() }
            .add(element.path.removeSuffix("[x]"))
        }

      return ChoiceTypeRegistry(
        packageName,
        modelTypes,
        assignSetNames(packageName, canonicalTypesBySignature, pathsBySignature),
        ancestorClosure(structureDefinitions),
        structureDefinitions.mapTo(hashSetOf()) { it.name.capitalized() },
      )
    }

    /**
     * Builds the transitive ancestor closure keyed by capitalized FHIR type name, from each
     * [StructureDefinition]'s `baseDefinition`. E.g. `Age → {Quantity}`, `Code → {String}`.
     */
    private fun ancestorClosure(
      structureDefinitions: List<StructureDefinition>
    ): Map<String, Set<String>> {
      val parent: Map<String, String> =
        structureDefinitions
          .filter {
            it.kind == StructureDefinition.Kind.PRIMITIVE_TYPE ||
              it.kind == StructureDefinition.Kind.COMPLEX_TYPE
          }
          .mapNotNull { sd ->
            val base =
              sd.baseDefinition?.substringAfterLast('/')?.capitalized() ?: return@mapNotNull null
            sd.name.capitalized() to base
          }
          .toMap()
      fun ancestorsOf(name: String): Set<String> {
        val result = linkedSetOf<String>()
        var current = parent[name]
        while (current != null && result.add(current)) {
          current = parent[current]
        }
        return result
      }
      return parent.keys.associateWith { ancestorsOf(it) }
    }

    /**
     * Names each distinct option-set, preferring human-readable names:
     * 1. the member "Or"-join when short enough (`CodeableConceptOrReference`,
     *    `DateTimeOrPeriodOrTiming`, `CanonicalOrCodeableConceptOrDataRequirementOrExpression`);
     * 2. otherwise the lexicographically-first declaring field path + `Choice` (e.g.
     *    `Observation.component.value` → `ObservationComponentValueChoice`).
     *
     * The fallback is keyed on a *declaring path* rather than a bare field name on purpose: a path
     * declares exactly one option-set, so the first (sorted) path is both unique across sets and
     * stable across regenerations. A bare field name is neither — every `value[x]` in the spec
     * would collapse to `ValueChoice` and only be told apart by an order-dependent `X` suffix.
     *
     * All names are deterministic and made unique with a trailing `X` only on the (now practically
     * impossible) clash. The tier-2 names set [ChoiceSet.compressed] (the name isn't the member
     * list), so callers prefer the per-resource alias at a use-site.
     */
    private fun assignSetNames(
      packageName: String,
      canonicalTypesBySignature: Map<String, List<Type>>,
      pathsBySignature: Map<String, Set<String>>,
    ): Map<String, ChoiceSet> {
      val usedNames = hashSetOf<String>()
      return canonicalTypesBySignature.entries
        .sortedBy { it.key }
        .associate { (signature, types) ->
          val joined = types.joinToString("Or") { choiceTypeExpansionName(it) }
          val paths = pathsBySignature[signature].orEmpty()
          val compressed = joined.length > MAX_JOINED_NAME_LENGTH
          var name =
            when {
              !compressed -> joined
              paths.isNotEmpty() ->
                paths.first().split('.').joinToString("") { it.capitalized() } + "Choice"
              // Every set is derived from at least one element, so a declaring path is always
              // present; this only guards against a future change and stays deterministic.
              else -> "Choice" + signature.hashCode().toUInt().toString(36)
            }
          while (!usedNames.add(name)) name += "X"
          signature to
            ChoiceSet(
              ClassName(packageName, CHOICE_TYPES_OBJECT, name),
              types,
              compressed,
              paths.toList(),
            )
        }
    }
  }
}
