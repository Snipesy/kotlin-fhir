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
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeAliasSpec
import com.squareup.kotlinpoet.TypeSpec

/**
 * Generates the consolidated choice types for one FHIR version, in the main model package (sealed
 * subtypes must share their interface's package, so everything lives here). Three files:
 * - `ChoiceBoxTypes.kt`: a top-level `<Type>Box` inline value class per expansion that is wrapped
 *   in some set, each implementing every set interface that wraps it (so the sealed `when` stays
 *   exhaustive);
 * - `FhirChoiceTypes.kt`: a single `object FhirChoiceTypes` nesting every option-set sealed
 *   interface, each exposing its members via a nested type alias (bare members alias the model type
 *   — via an aliased import so the self-named alias is non-cyclic; wrapped members alias the
 *   `<Type>Box`);
 * - `FhirChoiceExtensions.kt`: an `asX()` extension per member per set, returning the unwrapped
 *   model type (top-level, not interface members — those would clash across the sets a type joins);
 * - `FhirChoiceParticipants.kt`: a single `object FhirChoiceParticipants` nesting a `<Type>Choices`
 *   aggregate sealed interface per model type that is a bare member of ≥2 sets, collapsing its long
 *   supertype list to one (see [ChoiceTypeRegistry.choiceParticipants]).
 *
 * Bare members implement the interface from the model-class side ([ModelFileSpecGenerator]); the
 * public choice API (`Observation.Value`, `Observation.Value.Quantity`, `obs.value.asQuantity()`,
 * exhaustive `when`) is preserved while `obs.value = someQuantity` now works directly.
 */
object ChoiceTypesFileSpecGenerator {
  fun generate(registry: ChoiceTypeRegistry): List<FileSpec> {
    val files = mutableListOf<FileSpec>()

    // ChoiceBoxTypes.kt — a box type per expansion that is wrapped in at least one set.
    val boxTypes = FileSpec.builder(registry.packageName, "ChoiceBoxTypes")
    for (expansion in registry.wrappedExpansions) {
      val modelType = registry.modelType(expansion)
      boxTypes.addType(
        TypeSpec.classBuilder(registry.wrapperClassName(expansion))
          .addModifiers(KModifier.VALUE)
          .addAnnotation(ClassName("kotlin.jvm", "JvmInline"))
          .addKdoc(
            "A box type for the FHIR `%L` choice-type expansion — an inline wrapper around a [%T].\n" +
              "\n" +
              "It exists so `%L` can be a distinct, non-overlapping member of the shared choice " +
              "interfaces: a box is emitted only where the bare model type would be indistinguishable " +
              "from another member by an `is`-check (a FHIR ancestor/descendant such as " +
              "`Quantity`/`Age`, or a type the model can't implement directly). Most choice members " +
              "are bare and need no box.",
            expansion,
            modelType,
            expansion,
          )
          .primaryConstructor(FunSpec.constructorBuilder().addParameter("value", modelType).build())
          .addProperty(PropertySpec.builder("value", modelType).initializer("value").build())
          .apply { registry.setsWhereWrapped(expansion).forEach { addSuperinterface(it) } }
          .build()
      )
    }
    files += boxTypes.build()

    // FhirChoiceTypes.kt — every option-set interface, nested under one object so they don't
    // clutter the package's top-level namespace. An object body is a single file, hence one big
    // file.
    run {
      val file = FileSpec.builder(registry.packageName, ChoiceTypeRegistry.CHOICE_TYPES_OBJECT)
      val obj =
        TypeSpec.objectBuilder(ChoiceTypeRegistry.CHOICE_TYPES_OBJECT).addKdoc(CHOICE_TYPES_NOTE)
      val aliasedImports = mutableSetOf<String>()
      for (set in registry.choiceSets) {
        val iface =
          TypeSpec.interfaceBuilder(set.className)
            .addModifiers(KModifier.SEALED)
            .addKdoc(registry.unionDoc(set, includeDeclaringPaths = true))
        for (type in set.types) {
          val expansion = choiceTypeExpansionName(type)
          val modelType = registry.modelType(expansion)
          val wrapped = registry.isWrapped(set, expansion)
          // Bare alias RHS is the model type, whose simple name equals the expansion — so the
          // nested
          // `typealias <Expansion>` would be self-cyclic. Import the model type under a distinct
          // name
          // to break the cycle. (Wrapped aliases point at the distinctly-named box, so no import.)
          if (!wrapped && modelType.simpleName == expansion && aliasedImports.add(expansion)) {
            file.addAliasedImport(modelType, expansion + ALIAS_IMPORT_SUFFIX)
          }
          // Nested alias preserving the public spelling (`FhirChoiceTypes.Set.Quantity`); points at
          // the box when wrapped, else the model type. (The `asX()` accessors are top-level
          // extensions in FhirChoiceExtensions.kt — as members they'd clash across the many sets a
          // type joins.)
          iface.addTypeAlias(
            TypeAliasSpec.builder(
                expansion,
                if (wrapped) registry.wrapperClassName(expansion) else modelType,
              )
              .build()
          )
        }
        obj.addType(iface.build())
      }
      file.addType(obj.build())
      files += file.build()
    }

    // FhirChoiceExtensions.kt — an `asX()` accessor per member per set, returning the unwrapped
    // model type (unwrapping the box where wrapped). Top-level extensions, not interface members:
    // a member `asX()` would be inherited from every set a type joins and clash. They live in the
    // model package so `this as? Boolean` resolves to the FHIR `Boolean` (same-package precedence).
    run {
      val file = FileSpec.builder(registry.packageName, "FhirChoiceExtensions")
      for (set in registry.choiceSets) {
        for (type in set.types) {
          val expansion = choiceTypeExpansionName(type)
          val modelType = registry.modelType(expansion)
          val fn =
            FunSpec.builder("as$expansion")
              .receiver(set.className)
              .returns(modelType.copy(nullable = true))
          if (registry.isWrapped(set, expansion)) {
            fn.addStatement("return (this as? %T)?.value", registry.wrapperClassName(expansion))
          } else {
            fn.addStatement("return this as? %T", modelType)
          }
          file.addFunction(fn.build())
        }
      }
      files += file.build()
    }

    // FhirChoiceParticipants.kt — one `<Type>Choices` aggregate per model type that is bare in ≥2
    // sets, nested under one object so the model class header lists a single supertype.
    val participants = registry.choiceParticipants
    if (participants.isNotEmpty()) {
      val file = FileSpec.builder(registry.packageName, ChoiceTypeRegistry.PARTICIPANTS_OBJECT)
      val obj =
        TypeSpec.objectBuilder(ChoiceTypeRegistry.PARTICIPANTS_OBJECT).addKdoc(PARTICIPANTS_NOTE)
      for ((modelType, sets) in participants) {
        obj.addType(
          TypeSpec.interfaceBuilder(registry.aggregateClassName(modelType.simpleName))
            .addModifiers(KModifier.SEALED)
            .apply { sets.forEach { addSuperinterface(it) } }
            .build()
        )
      }
      file.addType(obj.build())
      files += file.build()
    }

    return files
  }

  /** Suffix for the aliased import that lets a bare member's self-named nested alias compile. */
  private const val ALIAS_IMPORT_SUFFIX = "Fhir"

  private val CHOICE_TYPES_NOTE =
    """
    GENERATED — not part of the FHIR spec.

    Every FHIR choice-type ("value[x]") option-set for this version, as a sealed interface namespaced
    under this object to keep the model package's top-level namespace uncluttered. Each is the type of
    one or more choice fields; its members implement it directly (bare) or via a top-level `<Type>Box`,
    and each member is exposed as a nested `typealias`. Match members with plain `is`/`as?`, or the
    `asX()` extensions in `FhirChoiceExtensions.kt`.
    """
      .trimIndent()

  private val PARTICIPANTS_NOTE =
    """
    GENERATED — not part of the FHIR spec.

    Every `<Type>Choices` sealed interface here bundles the choice-type option-sets that one model
    type is a bare member of, so that model class can declare a single supertype instead of a long
    list of `…Or…`/`…Choice` interfaces. They exist purely to keep the generated model headers
    readable and are an implementation detail — prefer the individual option-set types in code. Each
    is `sealed` with its model type as the sole subtype, so `when` exhaustiveness is preserved.
    """
      .trimIndent()
}
