/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Contributor
import dev.ohs.fhir.model.r4.Count
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Distance
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Oid
import dev.ohs.fhir.model.r4.ParameterDefinition
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.Uuid
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ExtensionSerializer : KSerializer<Extension> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Extension") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueBase64Binary",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element(
        "_valueBoolean",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueCanonical",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueDateTime",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element(
        "_valueDecimal",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueInstant",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element(
        "_valueInteger",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueMarkdown",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueOid", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element(
        "_valuePositiveInt",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element(
        "_valueUnsignedInt",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUrl", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUuid", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueAddress", lazyDescriptor { Address.serializer().descriptor }, isOptional = true)
      element("valueAge", lazyDescriptor { Age.serializer().descriptor }, isOptional = true)
      element(
        "valueAnnotation",
        lazyDescriptor { Annotation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueAttachment",
        lazyDescriptor { Attachment.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element("valueCoding", lazyDescriptor { Coding.serializer().descriptor }, isOptional = true)
      element(
        "valueContactPoint",
        lazyDescriptor { ContactPoint.serializer().descriptor },
        isOptional = true,
      )
      element("valueCount", lazyDescriptor { Count.serializer().descriptor }, isOptional = true)
      element(
        "valueDistance",
        lazyDescriptor { Distance.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueDuration",
        lazyDescriptor { Duration.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueHumanName",
        lazyDescriptor { HumanName.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueIdentifier",
        lazyDescriptor { Identifier.serializer().descriptor },
        isOptional = true,
      )
      element("valueMoney", lazyDescriptor { Money.serializer().descriptor }, isOptional = true)
      element("valuePeriod", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
      element(
        "valueQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element("valueRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element("valueRatio", lazyDescriptor { Ratio.serializer().descriptor }, isOptional = true)
      element(
        "valueReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueSampledData",
        lazyDescriptor { SampledData.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueSignature",
        lazyDescriptor { Signature.serializer().descriptor },
        isOptional = true,
      )
      element("valueTiming", lazyDescriptor { Timing.serializer().descriptor }, isOptional = true)
      element(
        "valueContactDetail",
        lazyDescriptor { ContactDetail.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueContributor",
        lazyDescriptor { Contributor.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueDataRequirement",
        lazyDescriptor { DataRequirement.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueExpression",
        lazyDescriptor { Expression.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueParameterDefinition",
        lazyDescriptor { ParameterDefinition.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueRelatedArtifact",
        lazyDescriptor { RelatedArtifact.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueTriggerDefinition",
        lazyDescriptor { TriggerDefinition.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueUsageContext",
        lazyDescriptor { UsageContext.serializer().descriptor },
        isOptional = true,
      )
      element("valueDosage", lazyDescriptor { Dosage.serializer().descriptor }, isOptional = true)
      element("valueMeta", lazyDescriptor { Meta.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Extension =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Extension) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Extension {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var url: KotlinString? = null
    var valueBase64Binary: KotlinString? = null
    var _valueBase64Binary: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueCanonical: KotlinString? = null
    var _valueCanonical: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueInstant: KotlinString? = null
    var _valueInstant: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueMarkdown: KotlinString? = null
    var _valueMarkdown: Element? = null
    var valueOid: KotlinString? = null
    var _valueOid: Element? = null
    var valuePositiveInt: Int? = null
    var _valuePositiveInt: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueUnsignedInt: Int? = null
    var _valueUnsignedInt: Element? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueUrl: KotlinString? = null
    var _valueUrl: Element? = null
    var valueUuid: KotlinString? = null
    var _valueUuid: Element? = null
    var valueAddress: Address? = null
    var valueAge: Age? = null
    var valueAnnotation: Annotation? = null
    var valueAttachment: Attachment? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueCoding: Coding? = null
    var valueContactPoint: ContactPoint? = null
    var valueCount: Count? = null
    var valueDistance: Distance? = null
    var valueDuration: Duration? = null
    var valueHumanName: HumanName? = null
    var valueIdentifier: Identifier? = null
    var valueMoney: Money? = null
    var valuePeriod: Period? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueReference: Reference? = null
    var valueSampledData: SampledData? = null
    var valueSignature: Signature? = null
    var valueTiming: Timing? = null
    var valueContactDetail: ContactDetail? = null
    var valueContributor: Contributor? = null
    var valueDataRequirement: DataRequirement? = null
    var valueExpression: Expression? = null
    var valueParameterDefinition: ParameterDefinition? = null
    var valueRelatedArtifact: RelatedArtifact? = null
    var valueTriggerDefinition: TriggerDefinition? = null
    var valueUsageContext: UsageContext? = null
    var valueDosage: Dosage? = null
    var valueMeta: Meta? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> url = decoder.decodeStringElement(descriptor, i)
        3 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        4 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        5 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        7 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        8 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        9 -> valueCode = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        11 -> valueDate = decoder.decodeStringElement(descriptor, i)
        12 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        13 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        14 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        15 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        16 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        17 -> valueId = decoder.decodeStringElement(descriptor, i)
        18 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        19 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        20 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        21 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        22 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        23 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        24 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        25 -> valueOid = decoder.decodeStringElement(descriptor, i)
        26 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        27 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        28 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        29 -> valueString = decoder.decodeStringElement(descriptor, i)
        30 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        31 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        32 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        33 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        34 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        35 -> valueUri = decoder.decodeStringElement(descriptor, i)
        36 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        37 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        38 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        39 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        40 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        41 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAddressSer, null)
        42 ->
          valueAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAgeSer, null)
        43 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAnnotationSer,
              null,
            )
        44 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        45 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        46 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        47 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactPointSer,
              null,
            )
        48 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCountSer, null)
        49 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDistanceSer, null)
        50 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        51 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueHumanNameSer,
              null,
            )
        52 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        53 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        54 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        55 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        56 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        57 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        58 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        59 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        60 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSignatureSer,
              null,
            )
        61 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueTimingSer, null)
        62 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactDetailSer,
              null,
            )
        63 ->
          valueContributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContributorSer,
              null,
            )
        64 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        65 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExpressionSer,
              null,
            )
        66 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        67 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        68 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        69 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueUsageContextSer,
              null,
            )
        70 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDosageSer, null)
        71 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Extension: " + i)
      }
    }
    return Extension(
      id = id,
      extension = extension ?: listOf(),
      url = url!!,
      `value` =
        (Base64Binary.of(valueBase64Binary, _valueBase64Binary)
          ?: R4Boolean.of(valueBoolean, _valueBoolean)
          ?: Canonical.of(valueCanonical, _valueCanonical)
          ?: Code.of(valueCode, _valueCode)
          ?: Date.of(FhirDate.fromString(valueDate), _valueDate)
          ?: DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime)
          ?: Decimal.of(valueDecimal, _valueDecimal)
          ?: Id.of(valueId, _valueId)
          ?: Instant.of(FhirDateTime.fromString(valueInstant), _valueInstant)
          ?: Integer.of(valueInteger, _valueInteger)
          ?: Markdown.of(valueMarkdown, _valueMarkdown)
          ?: Oid.of(valueOid, _valueOid)
          ?: PositiveInt.of(valuePositiveInt, _valuePositiveInt)
          ?: R4String.of(valueString, _valueString)
          ?: Time.of(valueTime, _valueTime)
          ?: UnsignedInt.of(valueUnsignedInt, _valueUnsignedInt)
          ?: Uri.of(valueUri, _valueUri)
          ?: Url.of(valueUrl, _valueUrl)
          ?: Uuid.of(valueUuid, _valueUuid)
          ?: valueAddress
          ?: valueAge
          ?: valueAnnotation
          ?: valueAttachment
          ?: valueCodeableConcept
          ?: valueCoding
          ?: valueContactPoint
          ?: valueCount
          ?: valueDistance
          ?: valueDuration
          ?: valueHumanName
          ?: valueIdentifier
          ?: valueMoney
          ?: valuePeriod
          ?: valueQuantity
          ?: valueRange
          ?: valueRatio
          ?: valueReference
          ?: valueSampledData
          ?: valueSignature
          ?: valueTiming
          ?: valueContactDetail
          ?: valueContributor
          ?: valueDataRequirement
          ?: valueExpression
          ?: valueParameterDefinition
          ?: valueRelatedArtifact
          ?: valueTriggerDefinition
          ?: valueUsageContext
          ?: valueDosage
          ?: valueMeta),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Extension) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    encoder.encodeStringElement(descriptor, 2, value.url)
    when (val choice = value.`value`) {
      null -> {}
      is Base64Binary -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueBase64BinarySer, it)
        }
      }
      is R4Boolean -> {
        ((choice.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Canonical -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Code -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Date -> {
        ((choice.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueBase64BinarySer, it)
        }
      }
      is DateTime -> {
        ((choice.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Decimal -> {
        ((choice.value))?.let {
          encoder.encodeSerializableElement(descriptor, 15, FhirDecimalSerializer, it)
        }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Id -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Instant -> {
        ((choice.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 19, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 20, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Integer -> {
        ((choice.value))?.let { encoder.encodeIntElement(descriptor, 21, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Markdown -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 23, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 24, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Oid -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 25, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 26, Hoisted.valueBase64BinarySer, it)
        }
      }
      is PositiveInt -> {
        ((choice.value))?.let { encoder.encodeIntElement(descriptor, 27, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 28, Hoisted.valueBase64BinarySer, it)
        }
      }
      is R4String -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 29, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 30, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Time -> {
        ((choice.value))?.let {
          encoder.encodeSerializableElement(descriptor, 31, LocalTimeSerializer, it)
        }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 32, Hoisted.valueBase64BinarySer, it)
        }
      }
      is UnsignedInt -> {
        ((choice.value))?.let { encoder.encodeIntElement(descriptor, 33, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 34, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Uri -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 35, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 36, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Url -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 37, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 38, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Uuid -> {
        ((choice.value))?.let { encoder.encodeStringElement(descriptor, 39, it) }
        (choice.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 40, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Address -> {
        encoder.encodeSerializableElement(descriptor, 41, Hoisted.valueAddressSer, choice)
      }
      is Age -> {
        encoder.encodeSerializableElement(descriptor, 42, Hoisted.valueAgeSer, choice)
      }
      is Annotation -> {
        encoder.encodeSerializableElement(descriptor, 43, Hoisted.valueAnnotationSer, choice)
      }
      is Attachment -> {
        encoder.encodeSerializableElement(descriptor, 44, Hoisted.valueAttachmentSer, choice)
      }
      is CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 45, Hoisted.valueCodeableConceptSer, choice)
      }
      is Coding -> {
        encoder.encodeSerializableElement(descriptor, 46, Hoisted.valueCodingSer, choice)
      }
      is ContactPoint -> {
        encoder.encodeSerializableElement(descriptor, 47, Hoisted.valueContactPointSer, choice)
      }
      is Count -> {
        encoder.encodeSerializableElement(descriptor, 48, Hoisted.valueCountSer, choice)
      }
      is Distance -> {
        encoder.encodeSerializableElement(descriptor, 49, Hoisted.valueDistanceSer, choice)
      }
      is Duration -> {
        encoder.encodeSerializableElement(descriptor, 50, Hoisted.valueDurationSer, choice)
      }
      is HumanName -> {
        encoder.encodeSerializableElement(descriptor, 51, Hoisted.valueHumanNameSer, choice)
      }
      is Identifier -> {
        encoder.encodeSerializableElement(descriptor, 52, Hoisted.valueIdentifierSer, choice)
      }
      is Money -> {
        encoder.encodeSerializableElement(descriptor, 53, Hoisted.valueMoneySer, choice)
      }
      is Period -> {
        encoder.encodeSerializableElement(descriptor, 54, Hoisted.valuePeriodSer, choice)
      }
      is Quantity -> {
        encoder.encodeSerializableElement(descriptor, 55, Hoisted.valueQuantitySer, choice)
      }
      is Range -> {
        encoder.encodeSerializableElement(descriptor, 56, Hoisted.valueRangeSer, choice)
      }
      is Ratio -> {
        encoder.encodeSerializableElement(descriptor, 57, Hoisted.valueRatioSer, choice)
      }
      is Reference -> {
        encoder.encodeSerializableElement(descriptor, 58, Hoisted.valueReferenceSer, choice)
      }
      is SampledData -> {
        encoder.encodeSerializableElement(descriptor, 59, Hoisted.valueSampledDataSer, choice)
      }
      is Signature -> {
        encoder.encodeSerializableElement(descriptor, 60, Hoisted.valueSignatureSer, choice)
      }
      is Timing -> {
        encoder.encodeSerializableElement(descriptor, 61, Hoisted.valueTimingSer, choice)
      }
      is ContactDetail -> {
        encoder.encodeSerializableElement(descriptor, 62, Hoisted.valueContactDetailSer, choice)
      }
      is Contributor -> {
        encoder.encodeSerializableElement(descriptor, 63, Hoisted.valueContributorSer, choice)
      }
      is DataRequirement -> {
        encoder.encodeSerializableElement(descriptor, 64, Hoisted.valueDataRequirementSer, choice)
      }
      is Expression -> {
        encoder.encodeSerializableElement(descriptor, 65, Hoisted.valueExpressionSer, choice)
      }
      is ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          66,
          Hoisted.valueParameterDefinitionSer,
          choice,
        )
      }
      is RelatedArtifact -> {
        encoder.encodeSerializableElement(descriptor, 67, Hoisted.valueRelatedArtifactSer, choice)
      }
      is TriggerDefinition -> {
        encoder.encodeSerializableElement(descriptor, 68, Hoisted.valueTriggerDefinitionSer, choice)
      }
      is UsageContext -> {
        encoder.encodeSerializableElement(descriptor, 69, Hoisted.valueUsageContextSer, choice)
      }
      is Dosage -> {
        encoder.encodeSerializableElement(descriptor, 70, Hoisted.valueDosageSer, choice)
      }
      is Meta -> {
        encoder.encodeSerializableElement(descriptor, 71, Hoisted.valueMetaSer, choice)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueBase64BinarySer: KSerializer<Element> = Element.serializer()

    public val valueAddressSer: KSerializer<Address> = Address.serializer()

    public val valueAgeSer: KSerializer<Age> = Age.serializer()

    public val valueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val valueCountSer: KSerializer<Count> = Count.serializer()

    public val valueDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val valueDurationSer: KSerializer<Duration> = Duration.serializer()

    public val valueHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val valueIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val valueMoneySer: KSerializer<Money> = Money.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valueSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val valueTimingSer: KSerializer<Timing> = Timing.serializer()

    public val valueContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val valueContributorSer: KSerializer<Contributor> = Contributor.serializer()

    public val valueDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val valueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val valueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val valueRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val valueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val valueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val valueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val valueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}
