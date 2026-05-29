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

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeAliasSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.backboneElements
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getBindingValueSetUrl
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.hasPrimaryConstructor
import dev.ohs.fhir.codegen.schema.isCommonBinding
import dev.ohs.fhir.codegen.schema.normalizeEnumName
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.sanitizeKDoc
import dev.ohs.fhir.codegen.schema.serializableWithCustomSerializer
import dev.ohs.fhir.codegen.schema.typeIsEnumeratedCode
import dev.ohs.fhir.codegen.schema.valueset.ValueSet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Generates a [FileSpec] for a model class. */
class ModelFileSpecGenerator(val codegenContext: CodegenContext) {

  fun generate(structureDefinition: StructureDefinition): FileSpec {
    // Nested enums are all created inside the enclosing parent class for reusability
    val enumClassesMap = mutableMapOf<String, TypeSpec>()
    val modelClassName = codegenContext.getModelClassName(structureDefinition)
    val typeSpec =
      TypeSpec.classBuilder(modelClassName)
        .apply {
          val structureDefinitionName = structureDefinition.name
          val isBaseClass = codegenContext.isBaseClass(structureDefinition)
          if (
            structureDefinitionName == "Resource" || structureDefinitionName == "DomainResource"
          ) {
            // We use open polymorphism to allow for runtime decision on which concrete class to
            // instantiate. So instead of sealing the `Resource` class and `DomainResource` class,
            // we keep them abstract.
            // See
            // https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/polymorphism.md#open-polymorphism
            addModifiers(KModifier.ABSTRACT)
          } else if (structureDefinition.abstract) {
            // All other abstract structure definitions should be sealed (and therefore abstract)
            // classes, except for Element which is concrete but open to be used for fields prefixed
            // with '_'.
            if (structureDefinition.name == "Element") {
              addModifiers(KModifier.OPEN)
              // Implement equals/hashCode for Element to compare properties (like data classes).
              addEqualsAndHashCodeFunctions(
                structureDefinition.name,
                structureDefinition.rootElements,
                modelClassName,
              )
            } else {
              addModifiers(KModifier.SEALED)
            }
          } else if (
            (structureDefinition.kind == StructureDefinition.Kind.COMPLEX_TYPE ||
              structureDefinition.kind == StructureDefinition.Kind.PRIMITIVE_TYPE) && isBaseClass
          ) {
            // Some primitive types and complex types have to be kept open (therefore not abstract)
            // since they need to be subclassed. E.g. Uri can be extended by Url, and Quantity can
            // be extended by Duration.
            addModifiers(KModifier.OPEN)
            // Implement equals/hashCode for open classes (to perform property-based comparison,
            // like data classes).
            addEqualsAndHashCodeFunctions(
              structureDefinition.name,
              structureDefinition.rootElements,
              modelClassName,
            )
          } else {
            addModifiers(KModifier.DATA)
          }

          // Serialization annotations
          if (structureDefinition.serializableWithCustomSerializer) {
            addAnnotation(
              AnnotationSpec.builder(Serializable::class)
                .addMember("with = %T::class", modelClassName.toSerializerClassName())
                .build()
            )
          } else if (structureDefinition.kind == StructureDefinition.Kind.RESOURCE) {
            // The abstract `Resource` root dispatches via `ResourcePolymorphicSerializer`: an
            // `AbstractPolymorphicSerializer<Resource>` that maps `resourceType` to a per-subclass
            // `XPolymorphicSerializer` (descriptor without `resourceType`, so kotlinx-json can
            // inject the class discriminator without colliding with a same-named field).
            if (structureDefinitionName == "Resource") {
              addAnnotation(
                AnnotationSpec.builder(Serializable::class)
                  .addMember(
                    "with = %T::class",
                    ClassName(modelClassName.packageName, "ResourcePolymorphicSerializer"),
                  )
                  .build()
              )
            } else {
              // All other resources (DomainResource, concrete subclasses) are serializable
              addAnnotation(Serializable::class)
            }
          } else if (structureDefinitionName == "Element") {
            // Element gets a hand-rolled custom serializer
            addAnnotation(
              AnnotationSpec.builder(Serializable::class)
                .addMember("with = %T::class", modelClassName.toSerializerClassName())
                .build()
            )
          } else if (structureDefinition.kind == StructureDefinition.Kind.PRIMITIVE_TYPE) {
            // FHIR primitive wrapper classes get a hand-rolled custom serializer. A custom
            // serializer (vs compiler-synthesized) sidesteps the duplicate-serial-name error that
            // would otherwise occur from inherited + overridden `@Serializable` properties
            // across Element → Primitive (and Primitive → refined primitives like Code/Canonical).
            addAnnotation(
              AnnotationSpec.builder(Serializable::class)
                .addMember("with = %T::class", modelClassName.toSerializerClassName())
                .build()
            )
          }

          // Serial name annotations for resources
          if (
            structureDefinition.kind == StructureDefinition.Kind.RESOURCE &&
              !structureDefinition.abstract
          ) {
            addAnnotation(
              AnnotationSpec.builder(SerialName::class)
                .addMember("%S", structureDefinitionName)
                .build()
            )
          }

          addKdoc(structureDefinition.description.sanitizeKDoc())

          // Set superclass if defined
          structureDefinition.baseDefinition?.substringAfterLast('/')?.capitalized()?.also {
            superclass(ClassName(modelClassName.packageName, it))
          }

          // This data type is a bare member of one or more shared choice-type interfaces —
          // implement them directly so `obs.value = someQuantity` works and the sealed `when` stays
          // exhaustive. Many memberships collapse into a single `<Type>Choices` aggregate (emitted
          // into FhirChoiceParticipants.kt by ChoiceTypesFileSpecGenerator) to keep this header
          // readable; the aggregate is sealed so exhaustiveness is preserved.
          codegenContext.choiceRegistry.bareSuperinterfacesFor(modelClassName.simpleName).forEach {
            addSuperinterface(it)
          }

          buildProperties(
            modelClassName,
            structureDefinition.rootElements,
            structureDefinition,
            isBaseClass,
            codegenContext.valueSetMap,
            codegenContext.choiceRegistry,
          )

          addBackboneElement(
            path = structureDefinitionName,
            enclosingModelClassName = modelClassName,
            backboneElements = structureDefinition.backboneElements,
            structureDefinition = structureDefinition,
            valueSetMap = codegenContext.valueSetMap,
            createEnumNameToTypeSpecEntry = { enumClassName, typeSpec ->
              enumClassesMap.putIfAbsent(enumClassName, typeSpec)
            },
          )

          addChoiceTypeAliases(
            modelClassName,
            structureDefinition.rootElements,
            codegenContext.choiceRegistry,
          )

          addModelBuilderSupport(
            structureDefinition,
            modelClassName,
            codegenContext.valueSetMap,
            isBaseClass = isBaseClass,
            choiceRegistry = codegenContext.choiceRegistry,
          )

          addEnumClassTypeSpec(
            valueSetMap = codegenContext.valueSetMap,
            elements = structureDefinition.rootElements,
            createEnumNameToTypeSpecEntry = { enumClassName, typeSpec ->
              enumClassesMap.putIfAbsent(enumClassName, typeSpec)
            },
          )

          if (structureDefinition.kind == StructureDefinition.Kind.PRIMITIVE_TYPE) {
            addToElementFunction(
              modelClassName.packageName,
              isBaseClass,
              // In R4 primitive types inherit from Element and in R5 they inherit from
              // PrimitiveType. If a type directly inherits Element or PrimitiveType do not
              // generate override modifier for the toElement function.
              structureDefinition.baseDefinition ==
                "http://hl7.org/fhir/StructureDefinition/Element" ||
                structureDefinition.baseDefinition ==
                  "http://hl7.org/fhir/StructureDefinition/PrimitiveType",
            )
            val valueType = propertySpecs.single { it.name == "value" }.type
            addType(
              TypeSpec.companionObjectBuilder()
                .apply {
                  when (structureDefinitionName) {
                    "xhtml" -> addOfFunctionForXhtml(modelClassName, valueType)
                    else -> addOfFunction(modelClassName, valueType)
                  }
                }
                .build()
            )
          }

          enumClassesMap.forEach {
            modelClassName.nestedClass(it.key)
            addType(it.value)
          }
        }
        .build()
    return FileSpec.builder(modelClassName).addType(typeSpec).build()
  }

  private fun TypeSpec.Builder.addEqualsAndHashCodeFunctions(
    name: String,
    elements: List<Element>,
    modelClassName: ClassName,
  ) {
    if (elements.isEmpty()) return
    val propertyMapper =
      PropertyMapper(
        PropertyMapper.MappingContext.MODEL,
        modelClassName,
        codegenContext.valueSetMap,
        codegenContext.choiceRegistry,
      )
    val properties = elements.map { propertyMapper.mapToProperty(it) }
    val equalsFunSpec =
      FunSpec.builder("equals")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("other", Any::class.asTypeName().copy(nullable = true))
        .returns(Boolean::class)
        .addCode(
          """
            if (this === other) return true
            if (other !is ${name.capitalized()}) return false
          """
            .trimIndent()
        )
        .addCode(
          properties.joinToString(separator = "\n", prefix = "\n", postfix = "\n") {
            "if (${it.name} != other.${it.name}) return false"
          }
        )
        .addCode("return true")
        .build()
    this.addFunction(equalsFunSpec)

    // Lift the property's static nullability straight off the [PropertyMapper] output instead of
    // re-deriving it from element constraints — keeps a single source of truth.
    fun hashCodeExpr(property: PropertyInfo): String =
      if (property.typeName.isNullable) "${property.name}?.hashCode() ?: 0"
      else "${property.name}.hashCode()"

    val hashCodeFunSpec =
      FunSpec.builder("hashCode")
        .addModifiers(KModifier.OVERRIDE)
        .returns(Int::class)
        .addCode(
          "// Using 31 improves hash distribution and reduces collisions in hash-based collections\n"
        )
        .addCode("var result = ${hashCodeExpr(properties.first())}")
        .addCode(
          properties.drop(1).joinToString(separator = "\n", prefix = "\n", postfix = "\n") {
            "result = 31 * result + (${hashCodeExpr(it)})"
          }
        )
        .addCode("return result")
        .build()
    this.addFunction(hashCodeFunSpec)
  }

  /** Adds a nested class for each BackboneElement in the [StructureDefinition]. */
  private fun TypeSpec.Builder.addBackboneElement(
    path: String,
    enclosingModelClassName: ClassName,
    backboneElements: Map<Element, List<Element>>,
    structureDefinition: StructureDefinition,
    valueSetMap: Map<String, ValueSet>,
    createEnumNameToTypeSpecEntry: (String, TypeSpec) -> Unit,
  ): TypeSpec.Builder {
    backboneElements
      .filter { (backboneElement, _) ->
        backboneElement.path.matches("$path\\.[A-Za-z0-9]+".toRegex())
      }
      .forEach { (backboneElement, elements) ->
        val name = backboneElement.path.substringAfterLast('.').capitalized()
        val backboneElementClassName = enclosingModelClassName.nestedClass(name)
        addType(
          TypeSpec.classBuilder(name)
            .addModifiers(KModifier.DATA)
            .addAnnotation(
              AnnotationSpec.builder(Serializable::class)
                .addMember("with = %T::class", backboneElementClassName.toSerializerClassName())
                .build()
            )
            .apply { addKdoc(backboneElement.definition.sanitizeKDoc()) }
            .apply {
              superclass(
                ClassName(enclosingModelClassName.packageName, backboneElement.type!!.single().code)
              )
            }
            .buildProperties(
              backboneElementClassName,
              elements,
              null,
              false,
              valueSetMap,
              codegenContext.choiceRegistry,
            )
            // Recursively add backbone elements inside a backbone element
            .addBackboneElement(
              backboneElement.path,
              backboneElementClassName,
              backboneElements,
              structureDefinition,
              valueSetMap,
              createEnumNameToTypeSpecEntry,
            )
            // Add choice-type aliases inside a backbone element
            .addChoiceTypeAliases(backboneElementClassName, elements, codegenContext.choiceRegistry)
            .addBackboneElementBuilderSupport(
              structureDefinition,
              backboneElementClassName,
              valueSetMap,
              elements,
              codegenContext.choiceRegistry,
            )
            .build()
        )
      }

    addEnumClassTypeSpec(
      valueSetMap = valueSetMap,
      elements = backboneElements.values.flatten(),
      createEnumNameToTypeSpecEntry = createEnumNameToTypeSpecEntry,
    )
    return this
  }

  /**
   * Adds [TypeSpec] for enum classes based on the [Element] definitions. This function also tracks
   * the ValueSet urls for common binding Elements.
   */
  private fun addEnumClassTypeSpec(
    valueSetMap: Map<String, ValueSet>,
    elements: List<Element>,
    createEnumNameToTypeSpecEntry: (String, TypeSpec) -> Unit,
  ) {
    elements
      .filter { it.typeIsEnumeratedCode(valueSetMap) && !it.isCommonBinding }
      .mapNotNull { element ->
        val valueSet = valueSetMap.getValue(element.getBindingValueSetUrl()!!)
        val valueSetName = valueSet.name.normalizeEnumName()
        EnumTypeSpecGenerator.generate(valueSetName, valueSet)?.let { typeSpec ->
          valueSetName to typeSpec
        }
      }
      .forEach { createEnumNameToTypeSpecEntry(it.first, it.second) }
  }
}

/**
 * Returns the class name of the custom `@Serializable(with = X::class)` serializer the compiler
 * plugin should use for a property of the given [typeName], or null if the default synthesized
 * serializer is fine. The serializer lives in the model's `<packageName>.serializers` sub-package.
 */
private fun customValueSerializerFor(typeName: TypeName, modelPackageName: String): ClassName? {
  val raw = typeName as? ClassName ?: return null
  val serializersPackage = "$modelPackageName.serializers"
  return when {
    raw.packageName == modelPackageName && raw.simpleName == "FhirDecimal" ->
      ClassName(serializersPackage, "FhirDecimalSerializer")
    raw.packageName == modelPackageName && raw.simpleName == "FhirDate" ->
      ClassName(serializersPackage, "FhirDateSerializer")
    raw.packageName == modelPackageName && raw.simpleName == "FhirDateTime" ->
      ClassName(serializersPackage, "FhirDateTimeSerializer")
    raw.packageName == "kotlinx.datetime" && raw.simpleName == "LocalTime" ->
      ClassName(serializersPackage, "LocalTimeSerializer")
    else -> null
  }
}

private fun TypeSpec.Builder.buildProperties(
  modelClassName: ClassName,
  elements: List<Element>,
  structureDefinition: StructureDefinition?, // null means backbone element
  isBaseClass: Boolean = false,
  valueSetMap: Map<String, ValueSet>,
  choiceRegistry: ChoiceTypeRegistry,
): TypeSpec.Builder {
  val propertyParameterPairs =
    elements.map { element ->
      val propertyMapper =
        PropertyMapper(
          PropertyMapper.MappingContext.MODEL,
          modelClassName,
          valueSetMap,
          choiceRegistry,
        )
      val propertyInfo = propertyMapper.mapToProperty(element)
      val property =
        PropertySpec.builder(propertyInfo.name, propertyInfo.typeName)
          .apply {
            if (structureDefinition == null || structureDefinition.hasPrimaryConstructor) {
              initializer(propertyInfo.name)
            }

            if (element.path != element.base?.path) {
              // Override properties in base classes
              addModifiers(KModifier.OVERRIDE)
            }

            if (structureDefinition?.abstract == true) {
              // Make properties open in base classes
              // Keep element's properties concrete since it is used in serialization
              if (modelClassName.simpleName == "Element") {
                addModifiers(KModifier.OPEN)
              } else {
                addModifiers(KModifier.ABSTRACT)
              }
            } else if (isBaseClass) {
              addModifiers(KModifier.OPEN)
            }

            // Attach an explicit `@Serializable(with = X::class)` for value types the compiler
            // plugin can't find a serializer for on its own (BigDecimal, FhirDate, FhirDateTime,
            // LocalTime). Typically applies only to primitive wrappers' `value` property.
            customValueSerializerFor(propertyInfo.typeName, modelClassName.packageName)?.let {
              customSerializer ->
              addAnnotation(
                AnnotationSpec.builder(Serializable::class)
                  .addMember("with = %T::class", customSerializer)
                  .build()
              )
            }

            addKdoc("%L", element.definition.sanitizeKDoc())
            element.comment?.let { addKdoc("\n\n%L", it.sanitizeKDoc()) }
            // For a choice property, also document the union of permitted types (the same note the
            // nested `typealias` carries) so it shows on the field itself.
            if (element.type != null && element.type.size > 1) {
              addKdoc("\n\n%L", choiceRegistry.unionDoc(element))
            }
          }
          .build()

      val parameter =
        ParameterSpec.builder(name = propertyInfo.name, type = propertyInfo.typeName)
          .apply { propertyInfo.defaultValue?.let { defaultValue(it) } }
          .build()

      return@map Pair(property, parameter)
    }

  addProperties(propertyParameterPairs.map { it.first })

  // Create primary constructor
  if (structureDefinition == null || structureDefinition.hasPrimaryConstructor) {
    primaryConstructor(
      FunSpec.constructorBuilder()
        .apply { propertyParameterPairs.forEach { addParameter(it.second) } }
        .build()
    )

    // Create superclass constructor
    if (
      structureDefinition?.kind == StructureDefinition.Kind.PRIMITIVE_TYPE &&
        structureDefinition.baseDefinition?.substringAfterLast('/')?.capitalized() !=
          "PrimitiveType"
    ) {
      elements
        .filter { it.path != it.base?.path }
        .forEach {
          addSuperclassConstructorParameter(
            "%N",
            PropertySpec.builder(
                it.getElementName(),
                String::class.asTypeName().copy(nullable = true),
              )
              .apply { initializer(it.id) }
              .build(),
          )
        }
    }
  }
  return this
}

/**
 * Adds a nested type alias for each choice type ("value[x]") element, pointing at the shared
 * consolidated option-set interface (e.g. `Observation.typealias Value = …`). Preserves the public
 * API spelling (`Observation.Value`, `Observation.Value.Quantity` via the interface's own nested
 * aliases, exhaustive `when`) while the member types implement the interface directly. The shared
 * interfaces and their `<Type>Box` box types are emitted by [ChoiceTypesFileSpecGenerator].
 */
private fun TypeSpec.Builder.addChoiceTypeAliases(
  enclosingModelClassName: ClassName,
  elements: List<Element>,
  registry: ChoiceTypeRegistry,
): TypeSpec.Builder {
  for (element in elements.filter { it.path.endsWith("[x]") }) {
    // Skip the alias when its name would shadow a type in scope (e.g. `DeviceRequest.code[x]` → a
    // `Code` alias clashing with the `Code` primitive); the property is typed with the shared set
    // directly in that case (see PropertyMapper.getSealedInterfaceType).
    if (registry.aliasNameCollides(element, enclosingModelClassName)) continue
    val fieldName = element.getElementName().capitalized()
    val set = registry.choiceSetFor(element)
    addTypeAlias(
      TypeAliasSpec.builder(fieldName, set.className).addKdoc(registry.unionDoc(set)).build()
    )
  }
  return this
}

/**
 * Adds a [FunSpec] for the `toElement` function that returns
 * - an `Element` for the FHIR primitive data type if either `id` or `extension` is present,
 * - `null`, otherwise.
 */
private fun TypeSpec.Builder.addToElementFunction(
  packageName: String,
  isBaseClass: Boolean,
  inheritsElement: Boolean,
) {
  addFunction(
    FunSpec.builder("toElement")
      .returns(ClassName(packageName, "Element").copy(nullable = true))
      .apply {
        if (isBaseClass) {
          addModifiers(KModifier.OPEN)
        }
        if (!inheritsElement) {
          addModifiers(KModifier.OVERRIDE)
        }
      }
      .addStatement(
        "if (id != null || extension.isNotEmpty()) { return %T(id, extension) }",
        ClassName(packageName, "Element"),
      )
      .addStatement("return null")
      .build()
  )
}

/**
 * Adds an `of(value, element)` factory on a FHIR primitive's companion that merges the two wire
 * fields — the primitive value and its `_field` Element sidecar (id + extensions) — into a single
 * model object, or returns null when both are absent.
 *
 * For `birthDate`, the wire has `birthDate` (`LocalDate`) and `_birthDate` (`Element`); the model
 * has a single `birthDate: Date` (the FHIR primitive carrying both).
 *
 * Generated example for `Date`:
 * ```
 * public companion object {
 *   public fun of(`value`: FhirDate?, element: Element?): Date? =
 *     if (value != null || element?.id != null || element?.extension?.isEmpty() == false) {
 *       Date(element?.id, element?.extension ?: mutableListOf(), value)
 *     } else {
 *       null
 *     }
 * }
 * ```
 *
 * The generated function is also useful for merging choice of types as separate decoded local
 * variables into a single object in the data model class. For example:
 * ```
 * Extension.Value?.from(
 *   Base64Binary.of(valueBase64Binary, _valueBase64Binary),
 *   R4bBoolean.of(valueBoolean, _valueBoolean),
 *   Canonical.of(valueCanonical, _valueCanonical),
 *   ...
 * )
 * ```
 *
 * The nullability here is critical since we generate `null` for choice type expansions whose wire
 * pair is absent. As a result, only one of the data types will be non-null, and the serialization
 * code will be able to correctly serialize the in-memory value to the correct data type.
 */
private fun TypeSpec.Builder.addOfFunction(
  className: ClassName,
  primitiveTypeName: TypeName,
): TypeSpec.Builder {
  addFunction(
    FunSpec.builder("of")
      .addParameter("value", primitiveTypeName.copy(nullable = true))
      .addParameter("element", ClassName(className.packageName, "Element").copy(nullable = true))
      .addCode(
        "return if (value != null || element?.id != null || element?.extension?.isEmpty() == false) { %T(element?.id, element?.extension ?: mutableListOf(), value) } else { null }",
        className,
      )
      .returns(className.copy(nullable = true))
      .build()
  )
  return this
}

/**
 * Adds an `of` function in the companion object in the `Xhtml` class to return a FHIR primitive
 * date type object from a Kotlin primitive string value and a FHIR `Element`.
 *
 * Same role as [addOfFunction] — merges the wire value and `_field` Element sidecar into a single
 * model object — but specialized for `Xhtml`, which cannot carry extensions.
 */
private fun TypeSpec.Builder.addOfFunctionForXhtml(
  className: ClassName,
  primitiveTypeName: TypeName,
): TypeSpec.Builder {
  addFunction(
    FunSpec.builder("of")
      .addParameter("value", primitiveTypeName)
      .addParameter("element", ClassName(className.packageName, "Element").copy(nullable = true))
      .addCode("return %T(element?.id, element?.extension ?: mutableListOf(), value)", className)
      .returns(className)
      .build()
  )
  return this
}

/**
 * Returns the nested-class name used for a sealed choice type expansion — e.g.
 * `Patient.Deceased.Boolean` for the `boolean` expansion. The subclass is NOT `@Serializable`; the
 * enclosing sealed interface's hand-rolled custom serializer handles all encode/decode, so there is
 * no synthesized `$serializer` that could trip over the lexical name clash (`value: Boolean`
 * resolving to the subclass).
 */
internal fun choiceTypeExpansionName(type: Type): String = type.code.capitalized()
