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

import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.capitalized

/**
 * FHIR datatype "family roots" — the anchor for the generated `<Root>Like` shape interfaces.
 *
 * In FHIR, `Age`/`Count`/`Distance`/`Duration` derive (`derivation = specialization`) from
 * `Quantity`; `Code`/`Id`/`Markdown` from `string`; `Url`/`Canonical`/`Oid`/`Uuid` from `uri`;
 * `positiveInt`/`unsignedInt` from `integer`. Modelling that as Kotlin inheritance (`Age :
 * Quantity`) makes `is Quantity` also match an `Age`, which would break sealed-`when`
 * exhaustiveness — so those members would otherwise need a `*Box`. Instead each specialization is
 * emitted as a distinct type that shares the root's shape via a `<Root>Like` interface, so `is
 * Age`/`is Quantity` are unambiguous and choice `when`s are box-free. This mirrors HAPI FHIR's
 * typed model-API interfaces (`IBaseDatatype`/`IPrimitiveType`).
 *
 * The root set is derived from the spec, not hardcoded: a root is the base of a `specialization`
 * datatype that is itself **concrete**. That yields `{Quantity, String, Uri, Integer}` and excludes
 * the universal abstract bases (`Element`/`PrimitiveType`/`Base`), adapting automatically to new
 * FHIR versions. `derivation = constraint` profiles (`SimpleQuantity`/`MoneyQuantity`) are excluded
 * by the `specialization` filter.
 */
fun computeDatatypeSpecializationRoots(
  structureDefinitions: List<StructureDefinition>
): Set<String> {
  val isConcrete: Map<String, Boolean> =
    structureDefinitions.associate { it.name.capitalized() to !it.abstract }
  return structureDefinitions
    .asSequence()
    .filter {
      (it.kind == StructureDefinition.Kind.PRIMITIVE_TYPE ||
        it.kind == StructureDefinition.Kind.COMPLEX_TYPE) && it.derivation == "specialization"
    }
    .mapNotNull { it.baseDefinition?.substringAfterLast('/')?.capitalized() }
    // Keep only bases that are themselves concrete datatypes — drops the universal abstract bases
    // (Element/PrimitiveType/Base) that every datatype ultimately derives from.
    .filter { isConcrete[it] == true }
    .toSet()
}

/** Whether [typeName] is a datatype family root that carries a `<Root>Like` shape interface. */
fun isDatatypeFamilyRoot(typeName: String, roots: Set<String>): Boolean =
  typeName.capitalized() in roots

/**
 * The capitalized root type name (e.g. `"Quantity"`, `"String"`) that this datatype is a structural
 * specialization of, or `null` if it is not one. Such types are emitted as *distinct* classes that
 * share the root's shape via `<Root>Like` (instead of subclassing the root), so `is Quantity`/`is
 * Age` are unambiguous concrete types and choice `when`s need no `*Box`. FHIR derivation is
 * structural conformance for validation, not OOP substitutability — the spec's own `value[x]`
 * choices list `valueAge`/`valueQuantity` as distinct keys.
 */
fun StructureDefinition.structuralSpecializationRoot(roots: Set<String>): String? {
  if (derivation != "specialization") return null
  val base = baseDefinition?.substringAfterLast('/')?.capitalized() ?: return null
  return base.takeIf { it in roots }
}

/**
 * Maps each family root to its own base type's simple name — the class a de-inherited
 * specialization must extend so it sits exactly where the root sits in the hierarchy. R4: every
 * root extends `Element`. R5: complex roots extend `DataType`, primitive roots extend
 * `PrimitiveType`. Hardcoding `Element` would skip those intermediate bases in R5.
 */
fun computeDatatypeSpecializationRootBases(
  structureDefinitions: List<StructureDefinition>,
  roots: Set<String>,
): Map<String, String> =
  structureDefinitions
    .filter { it.name.capitalized() in roots }
    .mapNotNull { sd ->
      sd.baseDefinition?.substringAfterLast('/')?.capitalized()?.let { sd.name.capitalized() to it }
    }
    .toMap()

/** The simple name of the shared shape interface for a (capitalized) root, e.g. `QuantityLike`. */
fun likeInterfaceSimpleName(capitalizedRoot: String): String = capitalizedRoot + "Like"
