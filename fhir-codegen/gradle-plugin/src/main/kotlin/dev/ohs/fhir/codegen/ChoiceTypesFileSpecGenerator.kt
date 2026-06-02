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
import com.squareup.kotlinpoet.TypeSpec

/**
 * Generates the choice-type support classes for one FHIR version, in the main model package (sealed
 * subtypes must share their interface's package, so everything lives here). Two files:
 * - `ChoiceBoxTypes.kt`: a top-level `<Type>Box` inline value class per expansion that is wrapped
 *   in some option-set, each implementing every per-field interface that wraps it (so the sealed
 *   `when` stays exhaustive);
 * - `FhirChoiceParticipants.kt`: a single `object FhirChoiceParticipants` nesting a `<Type>Choices`
 *   aggregate sealed interface per model type that is a bare member of ≥2 option-sets, collapsing
 *   its long supertype list to one (see [ChoiceTypeRegistry.choiceParticipants]).
 *
 * The per-field option-set interfaces themselves (`Observation.Value`, with a nested `typealias`
 * per member) are emitted by [ModelFileSpecGenerator]. Bare members implement them from the
 * model-class side; the public choice API (`Observation.Value`, `Observation.Value.Quantity`,
 * exhaustive `when`) is preserved while `obs.value = someQuantity` works directly.
 */
object ChoiceTypesFileSpecGenerator {
  fun generate(registry: ChoiceTypeRegistry): List<FileSpec> {
    val files = mutableListOf<FileSpec>()

    // ChoiceBoxTypes.kt — a box type per expansion that is wrapped in at least one set. This is a
    // FALLBACK for choice members that can't be a distinct *bare* type: a model type outside the
    // model package (e.g. `integer64` → `kotlin.Long`), or a FHIR ancestor/descendant of another
    // member. Since datatype specializations are de-inherited into distinct types sharing a
    // `<Root>Like` interface (see DatatypeSpecialization.kt), no such members exist today, so
    // `wrappedExpansions` is empty and this file is NOT emitted. Kept for future versions/types
    // (e.g. R5+ `integer64`) that would still need a box.
    if (registry.wrappedExpansions.isNotEmpty()) {
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
                "It exists so `%L` can be a distinct, non-overlapping member of the choice " +
                "interfaces: a box is emitted only where the bare model type would be indistinguishable " +
                "from another member by an `is`-check (a FHIR ancestor/descendant such as " +
                "`Quantity`/`Age`, or a type the model can't implement directly). Most choice members " +
                "are bare and need no box.",
              expansion,
              modelType,
              expansion,
            )
            .primaryConstructor(
              FunSpec.constructorBuilder().addParameter("value", modelType).build()
            )
            .addProperty(PropertySpec.builder("value", modelType).initializer("value").build())
            .apply { registry.setsWhereWrapped(expansion).forEach { addSuperinterface(it) } }
            .build()
        )
      }
      files += boxTypes.build()
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

  private val PARTICIPANTS_NOTE =
    """
    GENERATED — not part of the FHIR spec.

    Every `<Type>Choices` sealed interface here bundles the choice-type option-sets that one model
    type is a bare member of, so that model class can declare a single supertype instead of a long
    list of per-field interfaces. They exist purely to keep the generated model headers readable and
    are an implementation detail — prefer the individual option-set types in code. Each is `sealed`
    with its model type as the sole subtype, so `when` exhaustiveness is preserved.
    """
      .trimIndent()
}
