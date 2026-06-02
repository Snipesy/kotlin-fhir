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

/**
 * Registry of the choice-type ("value[x]") option-sets for a single FHIR version.
 *
 * FHIR choice types (e.g. `Patient.deceased[x]` → boolean | dateTime) are modelled as a nested
 * sealed interface, one per declaring field (e.g. `Patient.Deceased`, `Observation.Value`), with
 * one permitted subtype per allowed type. Rather than wrapping every member in a value class, the
 * member types implement the interface directly — *bare* — wherever that is type-safe, and the
 * interface exposes each member via a nested `typealias` (so `Observation.Value.Quantity` keeps
 * resolving to the member type).
 *
 * A member type T is **bare** in a set S (the model type implements S directly, no wrapper) unless
 * either:
 * - T's model type is not a class in the model package (only `integer64` → `kotlin.Long`), or
 * - S contains another member that is an ancestor or descendant of T (FHIR inheritance: `Quantity`
 *   ⊃ Age/Count/Distance/Duration, `String` ⊃ Code/Id/Markdown, `Uri` ⊃ Url/Canonical/Oid/Uuid,
 *   `Integer` ⊃ PositiveInt/UnsignedInt). Two members that are indistinguishable at an `is`-check
 *   would break exhaustiveness, so those are **boxed** in a shared `<Type>Box` value class instead.
 *   This only happens in the ~50-type "open" set and a handful of others.
 *
 * A bare member implements potentially many of these per-field interfaces, so its memberships are
 * collapsed into a single `<Type>Choices` aggregate (see [choiceParticipants]) to keep the model
 * class header readable. The box classes and the aggregates are emitted by
 * [ChoiceTypesFileSpecGenerator]; the same instance is shared with the model and serializer
 * generators so all references resolve consistently.
 */
class ChoiceTypeRegistry
private constructor(
  val packageName: String,
  /** Expansion name (e.g. `Quantity`) → the wrapped model value type (e.g. `…r4.Quantity`). */
  private val modelTypes: Map<String, ClassName>,
  /** Interface path (e.g. `Observation.value`) → its nested sealed-interface option-set. */
  private val setsByPath: Map<String, ChoiceSet>,
  /** Capitalized type name → its transitive ancestor capitalized names (via `baseDefinition`). */
  private val ancestorsByType: Map<String, Set<String>>,
) {
  /** A choice option-set: the nested sealed interface for one field and its member types. */
  data class ChoiceSet(
    val className: ClassName,
    /** Member types in canonical (alphabetical-by-expansion) order. */
    val types: List<Type>,
  )

  /** All option-sets, ordered by interface name for deterministic output. */
  val choiceSets: List<ChoiceSet> = setsByPath.values.sortedBy { it.className.canonicalName }

  /** The nested sealed interface [element] resolves to. */
  fun choiceSetFor(element: Element): ChoiceSet = setsByPath.getValue(interfacePathOf(element))

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

  /** The union KDoc for [element]'s choice type — for the property/parameter that holds it. */
  fun unionDoc(element: Element): CodeBlock = unionDoc(choiceSetFor(element))

  /**
   * KDoc describing the choice as the union of its members (each linked), wrapping long unions
   * across lines. Bare members link the model type; wrapped members link the `<Type>Box` box type.
   */
  fun unionDoc(set: ChoiceSet): CodeBlock {
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
    // suffix avoids colliding with the singular `…` option-set names.
    private const val AGGREGATE_SUFFIX = "Choices"

    // The per-type aggregates are namespaced under a single object so they don't clutter the model
    // package's top-level namespace. They must remain in this package — sealed subtypes can't cross
    // packages — so an object is the only namespacing device available.
    const val PARTICIPANTS_OBJECT = "FhirChoiceParticipants"
    /** Approximate column at which the union KDoc wraps to the next line. */
    private const val MAX_DOC_LINE_LENGTH = 72

    /**
     * The dotted path of the nested sealed interface for [element]. Normally the element's own path
     * (`Observation.value`). The one exception is `MetadataResource.versionAlgorithm[x]`, inherited
     * by every canonical resource: those reuse the base declaration's interface
     * (`CanonicalResource.VersionAlgorithm`) rather than each declaring their own — matching
     * [PropertyMapper.getSealedInterfaceType].
     */
    private fun interfacePathOf(element: Element): String {
      val base = element.base
      val path = if (base != null && element.id != base.path) base.path else element.path
      return path.removeSuffix("[x]")
    }

    private fun interfaceClassName(packageName: String, interfacePath: String): ClassName =
      ClassName(packageName, interfacePath.split('.').map { it.capitalized() })

    fun build(
      packageName: String,
      structureDefinitions: List<StructureDefinition>,
      datatypeSpecializationRoots: Set<String>,
    ): ChoiceTypeRegistry {
      // Package-only mapper: mapTypeToClassName depends solely on the (version) package name.
      val typeMapper =
        PropertyMapper(
          PropertyMapper.MappingContext.MODEL,
          ClassName(packageName, "Choice"),
          emptyMap(),
        )

      val modelTypes = sortedMapOf<String, ClassName>()
      // Insertion order preserved; one option-set per declaring interface path (inherited
      // versionAlgorithm fields collapse onto the base path, see interfacePathOf).
      val setsByPath = linkedMapOf<String, ChoiceSet>()

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
          val interfacePath = interfacePathOf(element)
          setsByPath.putIfAbsent(
            interfacePath,
            ChoiceSet(
              interfaceClassName(packageName, interfacePath),
              types.sortedBy { choiceTypeExpansionName(it) },
            ),
          )
        }

      return ChoiceTypeRegistry(
        packageName,
        modelTypes,
        setsByPath,
        ancestorClosure(structureDefinitions, datatypeSpecializationRoots),
      )
    }

    /**
     * Builds the transitive ancestor closure keyed by capitalized FHIR type name, from each
     * [StructureDefinition]'s `baseDefinition`. E.g. `Age → {Quantity}`, `Code → {String}`.
     */
    private fun ancestorClosure(
      structureDefinitions: List<StructureDefinition>,
      datatypeSpecializationRoots: Set<String>,
    ): Map<String, Set<String>> {
      val parent: Map<String, String> =
        structureDefinitions
          .filter {
            it.kind == StructureDefinition.Kind.PRIMITIVE_TYPE ||
              it.kind == StructureDefinition.Kind.COMPLEX_TYPE
          }
          .mapNotNull { sd ->
            if (sd.structuralSpecializationRoot(datatypeSpecializationRoots) != null)
              return@mapNotNull null
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
  }
}
