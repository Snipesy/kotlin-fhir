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

package dev.ohs.fhir.model.r5

/**
 * GENERATED — not part of the FHIR spec.
 *
 * Every `<Type>Choices` sealed interface here bundles the choice-type option-sets that one model
 * type is a bare member of, so that model class can declare a single supertype instead of a long
 * list of `…Or…`/`…Choice` interfaces. They exist purely to keep the generated model headers
 * readable and are an implementation detail — prefer the individual option-set types in code. Each
 * is `sealed` with its model type as the sole subtype, so `when` exhaustiveness is preserved.
 */
public object FhirChoiceParticipants {
  public sealed interface AddressChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.AddressOrReference,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice

  public sealed interface AgeChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming,
    FhirChoiceTypes.AgeOrDurationOrRangeOrTiming,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString

  public sealed interface AnnotationChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice

  public sealed interface AttachmentChoices :
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.AttachmentOrBase64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrCodeableConceptOrReference,
    FhirChoiceTypes.AttachmentOrReference,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice,
    FhirChoiceTypes.NutritionProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice

  public sealed interface Base64BinaryChoices :
    FhirChoiceTypes.AttachmentOrBase64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.NutritionProductCharacteristicValueChoice

  public sealed interface BooleanChoices :
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrQuantityOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrCodeableConcept,
    FhirChoiceTypes.BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime,
    FhirChoiceTypes.BooleanOrDateTime,
    FhirChoiceTypes.BooleanOrInteger,
    FhirChoiceTypes.BooleanOrReference,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice,
    FhirChoiceTypes.NutritionProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface CanonicalChoices :
    FhirChoiceTypes.CanonicalOrCodeableConceptOrReference,
    FhirChoiceTypes.CanonicalOrCoding,
    FhirChoiceTypes.CanonicalOrReference

  public sealed interface CodeableConceptChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.AttachmentOrBase64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.AttachmentOrCodeableConceptOrReference,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeableConcept,
    FhirChoiceTypes.BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrUri,
    FhirChoiceTypes.CodeableConceptOrDate,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrDurationOrPeriodOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrIdOrReference,
    FhirChoiceTypes.CodeableConceptOrDuration,
    FhirChoiceTypes.CodeableConceptOrMoney,
    FhirChoiceTypes.CodeableConceptOrQuantity,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatio,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatioOrRatioRange,
    FhirChoiceTypes.CodeableConceptOrReference,
    FhirChoiceTypes.CodeableConceptOrReferenceOrString,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice,
    FhirChoiceTypes.NutritionProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice

  public sealed interface CodingChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrQuantityOrString,
    FhirChoiceTypes.CanonicalOrCoding,
    FhirChoiceTypes.CanonicalOrCodingOrUri,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.CodingOrString,
    FhirChoiceTypes.CodingOrUri,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface ContactPointChoices :
    FhirChoiceTypes.ContactPointOrExtendedContactDetailOrStringOrUrl,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice

  public sealed interface DateChoices :
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime,
    FhirChoiceTypes.CodeableConceptOrDate,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateOrDuration,
    FhirChoiceTypes.DateOrPeriod,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DateTimeChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime,
    FhirChoiceTypes.BooleanOrDateTime,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrDurationOrPeriodOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrIdOrReference,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriod,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DecimalChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DecimalOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DurationChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDurationOrRangeOrTiming,
    FhirChoiceTypes.CodeableConceptOrDuration,
    FhirChoiceTypes.DateOrDuration,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.DurationOrRange,
    FhirChoiceTypes.DurationOrString

  public sealed interface ExtendedContactDetailChoices :
    FhirChoiceTypes.ContactPointOrExtendedContactDetailOrStringOrUrl,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice

  public sealed interface IdChoices :
    FhirChoiceTypes.BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrIdOrReference

  public sealed interface IdentifierChoices :
    FhirChoiceTypes.AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.IdentifierOrPositiveIntOrString,
    FhirChoiceTypes.IdentifierOrReference

  public sealed interface InstantChoices :
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice

  public sealed interface IntegerChoices :
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime,
    FhirChoiceTypes.BooleanOrInteger,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface Integer64Choices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice

  public sealed interface MarkdownChoices :
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.MarkdownOrReference,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice

  public sealed interface MoneyChoices :
    FhirChoiceTypes.CodeableConceptOrMoney,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.MoneyOrQuantity,
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt,
    FhirChoiceTypes.MoneyOrUnsignedInt

  public sealed interface PeriodChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrDurationOrPeriodOrQuantityOrRange,
    FhirChoiceTypes.DateOrPeriod,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriod,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.PeriodOrRange,
    FhirChoiceTypes.PeriodOrTiming

  public sealed interface QuantityChoices :
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.AttachmentOrBase64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrQuantityOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantity,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatio,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatioOrRatioRange,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.MedicinalProductDefinitionCharacteristicValueChoice,
    FhirChoiceTypes.MoneyOrQuantity,
    FhirChoiceTypes.NutritionProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuantityOrRange,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRangeOrString,
    FhirChoiceTypes.QuantityOrRatio,
    FhirChoiceTypes.QuantityOrRatioOrRatioRange,
    FhirChoiceTypes.QuantityOrRatioOrString,
    FhirChoiceTypes.QuantityOrString,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface RangeChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming,
    FhirChoiceTypes.AgeOrDurationOrRangeOrTiming,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrDurationOrPeriodOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.DecimalOrRange,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.DurationOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.PeriodOrRange,
    FhirChoiceTypes.QuantityOrRange,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRangeOrString,
    FhirChoiceTypes.RangeOrString

  public sealed interface RatioChoices :
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatio,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatioOrRatioRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRatio,
    FhirChoiceTypes.QuantityOrRatioOrRatioRange,
    FhirChoiceTypes.QuantityOrRatioOrString

  public sealed interface RatioRangeChoices :
    FhirChoiceTypes.CodeableConceptOrQuantityOrRatioOrRatioRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.QuantityOrRatioOrRatioRange

  public sealed interface ReferenceChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.AddressOrReference,
    FhirChoiceTypes.AdministrableProductDefinitionPropertyValueChoice,
    FhirChoiceTypes.AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrCodeableConceptOrReference,
    FhirChoiceTypes.AttachmentOrReference,
    FhirChoiceTypes.BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrReference,
    FhirChoiceTypes.CanonicalOrReference,
    FhirChoiceTypes.CanonicalOrReferenceOrUri,
    FhirChoiceTypes.CodeableConceptOrDateTimeOrIdOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrReference,
    FhirChoiceTypes.CodeableConceptOrReferenceOrString,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.IdentifierOrReference,
    FhirChoiceTypes.MarkdownOrReference,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice,
    FhirChoiceTypes.ReferenceOrString,
    FhirChoiceTypes.ReferenceOrStringOrUri,
    FhirChoiceTypes.ReferenceOrUrl

  public sealed interface SampledDataChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice

  public sealed interface StringChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBase64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BiologicallyDerivedProductPropertyValueChoice,
    FhirChoiceTypes.BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.CodeableConceptOrReferenceOrString,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.CodingOrString,
    FhirChoiceTypes.ContactPointOrExtendedContactDetailOrStringOrUrl,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.DateTimeOrString,
    FhirChoiceTypes.DevicePropertyValueChoice,
    FhirChoiceTypes.DurationOrString,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.IdentifierOrPositiveIntOrString,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt,
    FhirChoiceTypes.NutritionProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuantityOrRangeOrString,
    FhirChoiceTypes.QuantityOrRatioOrString,
    FhirChoiceTypes.QuantityOrString,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice,
    FhirChoiceTypes.RangeOrString,
    FhirChoiceTypes.ReferenceOrString,
    FhirChoiceTypes.ReferenceOrStringOrUri,
    FhirChoiceTypes.StringOrUri

  public sealed interface TimeChoices :
    FhirChoiceTypes.AuditEventEntityDetailValueChoice,
    FhirChoiceTypes.BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface TimingChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming,
    FhirChoiceTypes.AgeOrDurationOrRangeOrTiming,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.PeriodOrTiming

  public sealed interface UnsignedIntChoices :
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt, FhirChoiceTypes.MoneyOrUnsignedInt

  public sealed interface UriChoices :
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.CodingOrUri,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ReferenceOrStringOrUri,
    FhirChoiceTypes.StringOrUri

  public sealed interface UrlChoices :
    FhirChoiceTypes.ContactPointOrExtendedContactDetailOrStringOrUrl,
    FhirChoiceTypes.InventoryItemCharacteristicValueChoice,
    FhirChoiceTypes.MarkdownOrStringOrUrl,
    FhirChoiceTypes.ReferenceOrUrl
}
