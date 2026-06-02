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
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * Emits the shape interfaces into a single `DatatypeLikeInterfaces.kt` file:
 * - [ELEMENT_LIKE] (`ElementLike`) — the `Element` portion (`id`/`extension`), implemented by the
 *   `Element` class itself, so *every* element-shaped model type is an `ElementLike`. This mirrors
 *   HAPI FHIR's `IBaseElement`/`IBaseHasExtensions` model API.
 * - `<Root>Like` (`QuantityLike`/`StringLike`/`UriLike`/`IntegerLike`) — `ElementLike` plus the
 *   root datatype's value-carrying properties (e.g. `value`/`comparator`/`unit`/`system`/`code` for
 *   `Quantity`). The root and every structural specialization (see [structuralSpecializationRoot])
 *   implement it.
 *
 * Lets callers read a family's fields *and* its element portion generically (`q.value`, `q.id`,
 * `q.extension` on a `QuantityLike`) without the specializations subclassing the root. A single
 * `override val` on each impl satisfies both the superclass member and the interface member.
 */
object DatatypeLikeFileSpecGenerator {
  const val ELEMENT_LIKE = "ElementLike"
  private const val FILE_NAME = "DatatypeLikeInterfaces"

  fun generate(
    structureDefinitions: List<StructureDefinition>,
    valueSetMap: Map<String, ValueSet>,
    packageName: String,
    datatypeSpecializationRoots: Set<String>,
  ): List<FileSpec> {
    val byName = structureDefinitions.associateBy { it.name.capitalized() }
    val types = mutableListOf<TypeSpec>()

    // ElementLike — the shared element portion (id/extension), extended by every <Root>Like.
    byName["Element"]?.let { element ->
      shapeInterface(
          simpleName = ELEMENT_LIKE,
          ownerSimpleName = "Element",
          elements = element.rootElements,
          valueSetMap = valueSetMap,
          packageName = packageName,
          superinterface = null,
          kdoc =
            "The shared `Element` portion of the FHIR datatype model — `id` and `extension`.\n" +
              "\n" +
              "Implemented by `Element` (and therefore by every element-shaped type), and extended\n" +
              "by each `<Root>Like` family interface.",
        )
        ?.let { types += it }
    }

    // <Root>Like — ElementLike plus the root datatype's value-carrying properties.
    datatypeSpecializationRoots.sorted().forEach { root ->
      val sd = byName[root] ?: return@forEach
      shapeInterface(
          simpleName = likeInterfaceSimpleName(root),
          ownerSimpleName = root,
          // Only the root's own (non-inherited) data properties — id/extension come from
          // ElementLike.
          elements = sd.rootElements.filter { it.path == it.base?.path },
          valueSetMap = valueSetMap,
          packageName = packageName,
          superinterface = ClassName(packageName, ELEMENT_LIKE),
          kdoc =
            "Shared shape of the FHIR `$root` datatype family.\n" +
              "\n" +
              "Implemented by `$root` and each of its structural specializations, so callers can\n" +
              "read the common fields generically via `x as? ${likeInterfaceSimpleName(root)}` " +
              "(including\nthe `ElementLike` `id`/`extension`) without those specializations " +
              "subclassing `$root`.",
        )
        ?.let { types += it }
    }

    if (types.isEmpty()) return emptyList()
    val file = FileSpec.builder(packageName, FILE_NAME)
    types.forEach { file.addType(it) }
    return listOf(file.build())
  }

  private fun shapeInterface(
    simpleName: String,
    ownerSimpleName: String,
    elements: List<Element>,
    valueSetMap: Map<String, ValueSet>,
    packageName: String,
    superinterface: ClassName?,
    kdoc: String,
  ): TypeSpec? {
    val ownerClassName = ClassName(packageName, ownerSimpleName)
    val mapper = PropertyMapper(PropertyMapper.MappingContext.MODEL, ownerClassName, valueSetMap)
    // PropertyMapper renders an owner's own nested enum (e.g. Quantity.comparator →
    // QuantityComparator) as an empty-package ClassName — self-referential, fine inside the owner's
    // file but an unresolved import here. Re-qualify those under the owner class.
    fun qualify(type: TypeName): TypeName =
      when (type) {
        is ParameterizedTypeName ->
          type.rawType
            .parameterizedBy(type.typeArguments.map(::qualify))
            .copy(nullable = type.isNullable)
        is ClassName ->
          if (type.packageName.isEmpty())
            ClassName(packageName, ownerSimpleName, type.simpleName)
              .copy(nullable = type.isNullable)
          else type
        else -> type
      }
    val properties =
      elements.map { mapper.mapToProperty(it) }.map { it.name to qualify(it.typeName) }
    if (properties.isEmpty()) return null
    return TypeSpec.interfaceBuilder(simpleName)
      .addKdoc(kdoc)
      .apply {
        superinterface?.let { addSuperinterface(it) }
        properties.forEach { (name, type) -> addProperty(PropertySpec.builder(name, type).build()) }
      }
      .build()
  }
}
