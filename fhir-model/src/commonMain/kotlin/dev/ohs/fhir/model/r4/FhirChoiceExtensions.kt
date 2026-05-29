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

package dev.ohs.fhir.model.r4

public fun FhirChoiceTypes.AddressOrCodeableConceptOrReference.asAddress(): Address? =
  this as? Address

public fun FhirChoiceTypes.AddressOrCodeableConceptOrReference.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.AddressOrCodeableConceptOrReference.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.AddressOrReference.asAddress(): Address? = this as? Address

public fun FhirChoiceTypes.AddressOrReference.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString.asAge(): Age? = this as? Age

public fun FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming.asAge(): Age? =
  this as? Age

public fun FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming.asDuration(): Duration? =
  this as? Duration

public fun FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming.asPeriod(): Period? =
  this as? Period

public fun FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming.asRange(): Range? =
  this as? Range

public fun FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming.asTiming(): Timing? =
  this as? Timing

public fun FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString.asAge(): Age? = this as? Age

public fun FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString.asPeriod(): Period? =
  this as? Period

public fun FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString.asString(): String? =
  this as? String

public fun FhirChoiceTypes.AgeOrPeriodOrRangeOrString.asAge(): Age? = this as? Age

public fun FhirChoiceTypes.AgeOrPeriodOrRangeOrString.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.AgeOrPeriodOrRangeOrString.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.AgeOrPeriodOrRangeOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.AgeOrRangeOrString.asAge(): Age? = this as? Age

public fun FhirChoiceTypes.AgeOrRangeOrString.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.AgeOrRangeOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString.asAttachment():
  Attachment? = this as? Attachment

public fun FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString.asQuantity():
  Quantity? = this as? Quantity

public fun FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString.asReference():
  Reference? = this as? Reference

public fun FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString.asString(): String? =
  this as? String

public fun FhirChoiceTypes.AttachmentOrReference.asAttachment(): Attachment? = this as? Attachment

public fun FhirChoiceTypes.AttachmentOrReference.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.AttachmentOrReferenceOrString.asAttachment(): Attachment? =
  this as? Attachment

public fun FhirChoiceTypes.AttachmentOrReferenceOrString.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.AttachmentOrReferenceOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString.asBase64Binary():
  Base64Binary? = this as? Base64Binary

public fun FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString.asString(): String? =
  this as? String

public fun FhirChoiceTypes.Base64BinaryOrString.asBase64Binary(): Base64Binary? =
  this as? Base64Binary

public fun FhirChoiceTypes.Base64BinaryOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.BooleanOrCanonical.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrCanonical.asCanonical(): Canonical? = this as? Canonical

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asBoolean():
  Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asCode():
  Code? = (this as? CodeBox)?.value

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asCoding():
  Coding? = this as? Coding

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asDateTime():
  DateTime? = this as? DateTime

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asDecimal():
  Decimal? = this as? Decimal

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asInteger():
  Integer? = this as? Integer

public fun FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString.asString():
  String? = (this as? StringBox)?.value

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asBoolean():
  Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asCode(): Code? =
  (this as? CodeBox)?.value

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asDateTime():
  DateTime? = this as? DateTime

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asDecimal():
  Decimal? = this as? Decimal

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asInteger():
  Integer? = this as? Integer

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asString():
  String? = (this as? StringBox)?.value

public fun FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri.asUri(): Uri? =
  this as? Uri

public fun FhirChoiceTypes.BooleanOrCodeableConcept.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrCodeableConcept.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange.asRange(): Range? =
  this as? Range

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference.asBoolean():
  Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference.asQuantity():
  Quantity? = this as? Quantity

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference.asRange(): Range? =
  this as? Range

public fun FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference.asReference():
  Reference? = this as? Reference

public fun FhirChoiceTypes.BooleanOrDateTime.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrDateTime.asDateTime(): DateTime? = this as? DateTime

public fun FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString.asDecimal(): Decimal? =
  this as? Decimal

public fun FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString.asId(): Id? =
  (this as? IdBox)?.value

public fun FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString.asInteger(): Integer? =
  this as? Integer

public fun FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString.asString(): String? =
  (this as? StringBox)?.value

public fun FhirChoiceTypes.BooleanOrInteger.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrInteger.asInteger(): Integer? = this as? Integer

public fun FhirChoiceTypes.BooleanOrReference.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.BooleanOrReference.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression.asCanonical():
  Canonical? = this as? Canonical

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression
  .asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression
  .asDataRequirement(): DataRequirement? = this as? DataRequirement

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression.asExpression():
  Expression? = this as? Expression

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrUri.asCanonical(): Canonical? =
  (this as? CanonicalBox)?.value

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrUri.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CanonicalOrCodeableConceptOrUri.asUri(): Uri? = (this as? UriBox)?.value

public fun FhirChoiceTypes.CanonicalOrUri.asCanonical(): Canonical? = (this as? CanonicalBox)?.value

public fun FhirChoiceTypes.CanonicalOrUri.asUri(): Uri? = (this as? UriBox)?.value

public fun FhirChoiceTypes.CodeableConceptOrDate.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrDate.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.CodeableConceptOrDuration.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrDuration.asDuration(): Duration? = this as? Duration

public fun FhirChoiceTypes.CodeableConceptOrQuantity.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrQuantity.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRange.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRange.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference.asRange(): Range? =
  this as? Range

public fun FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.CodeableConceptOrRange.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.CodeableConceptOrReference.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.CodeableConceptOrReference.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime.asCoding(): Coding? =
  this as? Coding

public fun FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime.asDate(): Date? =
  this as? Date

public fun FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime.asInteger(): Integer? =
  this as? Integer

public fun FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime.asReference():
  Reference? = this as? Reference

public fun FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime.asString(): String? =
  this as? String

public fun FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime.asTime(): Time? =
  this as? Time

public fun FhirChoiceTypes.CodingOrUri.asCoding(): Coding? = this as? Coding

public fun FhirChoiceTypes.CodingOrUri.asUri(): Uri? = this as? Uri

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asAttachment(): Attachment? =
  this as? Attachment

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asCoding(): Coding? = this as? Coding

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asDecimal(): Decimal? =
  this as? Decimal

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asInteger(): Integer? =
  this as? Integer

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asString(): String? = this as? String

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asTime(): Time? = this as? Time

public fun FhirChoiceTypes.ContractTermOfferAnswerValueChoice.asUri(): Uri? = this as? Uri

public fun FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming.asTiming(): Timing? = this as? Timing

public fun FhirChoiceTypes.DateOrDuration.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.DateOrDuration.asDuration(): Duration? = this as? Duration

public fun FhirChoiceTypes.DateOrPeriod.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.DateOrPeriod.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateOrPeriodOrString.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.DateOrPeriodOrString.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateOrPeriodOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriod.asDateTime(): DateTime? = this as? DateTime

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriod.asDuration(): Duration? = this as? Duration

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriod.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming.asDuration(): Duration? =
  this as? Duration

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming.asTiming(): Timing? = this as? Timing

public fun FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming.asInstant(): Instant? =
  this as? Instant

public fun FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming.asTiming(): Timing? = this as? Timing

public fun FhirChoiceTypes.DateTimeOrPeriod.asDateTime(): DateTime? = this as? DateTime

public fun FhirChoiceTypes.DateTimeOrPeriod.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateTimeOrPeriodOrTiming.asDateTime(): DateTime? = this as? DateTime

public fun FhirChoiceTypes.DateTimeOrPeriodOrTiming.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DateTimeOrPeriodOrTiming.asTiming(): Timing? = this as? Timing

public fun FhirChoiceTypes.DateTimeOrString.asDateTime(): DateTime? = this as? DateTime

public fun FhirChoiceTypes.DateTimeOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.DecimalOrRange.asDecimal(): Decimal? = this as? Decimal

public fun FhirChoiceTypes.DecimalOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.DurationOrPeriodOrRange.asDuration(): Duration? = this as? Duration

public fun FhirChoiceTypes.DurationOrPeriodOrRange.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.DurationOrPeriodOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.DurationOrRange.asDuration(): Duration? = this as? Duration

public fun FhirChoiceTypes.DurationOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asAddress(): Address? =
  this as? Address

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asAge(): Age? =
  (this as? AgeBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asAnnotation(): Annotation? =
  this as? Annotation

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asAttachment(): Attachment? =
  this as? Attachment

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asBase64Binary(): Base64Binary? =
  this as? Base64Binary

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asCanonical(): Canonical? =
  (this as? CanonicalBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asCode(): Code? =
  (this as? CodeBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asCoding(): Coding? = this as? Coding

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asContactDetail(): ContactDetail? =
  this as? ContactDetail

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asContactPoint(): ContactPoint? =
  this as? ContactPoint

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asContributor(): Contributor? =
  this as? Contributor

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asCount(): Count? =
  (this as? CountBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDataRequirement():
  DataRequirement? = this as? DataRequirement

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDecimal(): Decimal? =
  this as? Decimal

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDistance(): Distance? =
  (this as? DistanceBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDosage(): Dosage? = this as? Dosage

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asDuration(): Duration? =
  (this as? DurationBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asExpression(): Expression? =
  this as? Expression

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asHumanName(): HumanName? =
  this as? HumanName

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asId(): Id? = (this as? IdBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asIdentifier(): Identifier? =
  this as? Identifier

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asInstant(): Instant? =
  this as? Instant

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asInteger(): Integer? =
  (this as? IntegerBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asMarkdown(): Markdown? =
  (this as? MarkdownBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asMeta(): Meta? = this as? Meta

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asMoney(): Money? = this as? Money

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asOid(): Oid? =
  (this as? OidBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asParameterDefinition():
  ParameterDefinition? = this as? ParameterDefinition

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asPositiveInt(): PositiveInt? =
  (this as? PositiveIntBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asQuantity(): Quantity? =
  (this as? QuantityBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asRatio(): Ratio? = this as? Ratio

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asRelatedArtifact():
  RelatedArtifact? = this as? RelatedArtifact

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asSampledData(): SampledData? =
  this as? SampledData

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asSignature(): Signature? =
  this as? Signature

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asString(): String? =
  (this as? StringBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asTime(): Time? = this as? Time

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asTiming(): Timing? = this as? Timing

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asTriggerDefinition():
  TriggerDefinition? = this as? TriggerDefinition

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asUnsignedInt(): UnsignedInt? =
  (this as? UnsignedIntBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asUri(): Uri? =
  (this as? UriBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asUrl(): Url? =
  (this as? UrlBox)?.value

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asUsageContext(): UsageContext? =
  this as? UsageContext

public fun FhirChoiceTypes.ElementDefinitionDefaultValueChoice.asUuid(): Uuid? =
  (this as? UuidBox)?.value

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asDecimal(): Decimal? = this as? Decimal

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asInstant(): Instant? = this as? Instant

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asInteger(): Integer? =
  (this as? IntegerBox)?.value

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asPositiveInt(): PositiveInt? =
  (this as? PositiveIntBox)?.value

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asTime(): Time? = this as? Time

public fun FhirChoiceTypes.ElementDefinitionMaxValueChoice.asUnsignedInt(): UnsignedInt? =
  (this as? UnsignedIntBox)?.value

public fun FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice.asCanonical():
  Canonical? = this as? Canonical

public fun FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice.asCodeableConcept():
  CodeableConcept? = this as? CodeableConcept

public fun FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice.asDataRequirement():
  DataRequirement? = this as? DataRequirement

public fun FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice.asExpression():
  Expression? = this as? Expression

public fun FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice.asReference():
  Reference? = this as? Reference

public fun FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice.asTriggerDefinition():
  TriggerDefinition? = this as? TriggerDefinition

public fun FhirChoiceTypes.GoalTargetDetailChoice.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.GoalTargetDetailChoice.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.GoalTargetDetailChoice.asInteger(): Integer? = this as? Integer

public fun FhirChoiceTypes.GoalTargetDetailChoice.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.GoalTargetDetailChoice.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.GoalTargetDetailChoice.asRatio(): Ratio? = this as? Ratio

public fun FhirChoiceTypes.GoalTargetDetailChoice.asString(): String? = this as? String

public fun FhirChoiceTypes.IdentifierOrReference.asIdentifier(): Identifier? = this as? Identifier

public fun FhirChoiceTypes.IdentifierOrReference.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.MoneyOrQuantity.asMoney(): Money? = this as? Money

public fun FhirChoiceTypes.MoneyOrQuantity.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.MoneyOrStringOrUnsignedInt.asMoney(): Money? = this as? Money

public fun FhirChoiceTypes.MoneyOrStringOrUnsignedInt.asString(): String? = this as? String

public fun FhirChoiceTypes.MoneyOrStringOrUnsignedInt.asUnsignedInt(): UnsignedInt? =
  this as? UnsignedInt

public fun FhirChoiceTypes.MoneyOrUnsignedInt.asMoney(): Money? = this as? Money

public fun FhirChoiceTypes.MoneyOrUnsignedInt.asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

public fun FhirChoiceTypes.ObservationComponentValueChoice.asBoolean(): Boolean? = this as? Boolean

public fun FhirChoiceTypes.ObservationComponentValueChoice.asCodeableConcept(): CodeableConcept? =
  this as? CodeableConcept

public fun FhirChoiceTypes.ObservationComponentValueChoice.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.ObservationComponentValueChoice.asInteger(): Integer? = this as? Integer

public fun FhirChoiceTypes.ObservationComponentValueChoice.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.ObservationComponentValueChoice.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.ObservationComponentValueChoice.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.ObservationComponentValueChoice.asRatio(): Ratio? = this as? Ratio

public fun FhirChoiceTypes.ObservationComponentValueChoice.asSampledData(): SampledData? =
  this as? SampledData

public fun FhirChoiceTypes.ObservationComponentValueChoice.asString(): String? = this as? String

public fun FhirChoiceTypes.ObservationComponentValueChoice.asTime(): Time? = this as? Time

public fun FhirChoiceTypes.PeriodOrRange.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.PeriodOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.PeriodOrStringOrTiming.asPeriod(): Period? = this as? Period

public fun FhirChoiceTypes.PeriodOrStringOrTiming.asString(): String? = this as? String

public fun FhirChoiceTypes.PeriodOrStringOrTiming.asTiming(): Timing? = this as? Timing

public fun FhirChoiceTypes.PositiveIntOrString.asPositiveInt(): PositiveInt? = this as? PositiveInt

public fun FhirChoiceTypes.PositiveIntOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.QuantityOrRange.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.QuantityOrRange.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.QuantityOrRangeOrRatio.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.QuantityOrRangeOrRatio.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.QuantityOrRangeOrRatio.asRatio(): Ratio? = this as? Ratio

public fun FhirChoiceTypes.QuantityOrRangeOrRatioOrString.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.QuantityOrRangeOrRatioOrString.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.QuantityOrRangeOrRatioOrString.asRatio(): Ratio? = this as? Ratio

public fun FhirChoiceTypes.QuantityOrRangeOrRatioOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.QuantityOrRangeOrString.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.QuantityOrRangeOrString.asRange(): Range? = this as? Range

public fun FhirChoiceTypes.QuantityOrRangeOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.QuantityOrRatio.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.QuantityOrRatio.asRatio(): Ratio? = this as? Ratio

public fun FhirChoiceTypes.QuantityOrString.asQuantity(): Quantity? = this as? Quantity

public fun FhirChoiceTypes.QuantityOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asBoolean(): Boolean? =
  this as? Boolean

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asCoding(): Coding? =
  this as? Coding

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asDate(): Date? = this as? Date

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asDateTime(): DateTime? =
  this as? DateTime

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asDecimal(): Decimal? =
  this as? Decimal

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asInteger(): Integer? =
  this as? Integer

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asQuantity(): Quantity? =
  this as? Quantity

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asReference(): Reference? =
  this as? Reference

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asString(): String? =
  this as? String

public fun FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice.asTime(): Time? = this as? Time

public fun FhirChoiceTypes.ReferenceOrString.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.ReferenceOrString.asString(): String? = this as? String

public fun FhirChoiceTypes.ReferenceOrUrl.asReference(): Reference? = this as? Reference

public fun FhirChoiceTypes.ReferenceOrUrl.asUrl(): Url? = this as? Url
