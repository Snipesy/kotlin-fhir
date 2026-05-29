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
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice

  public sealed interface AgeChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString

  public sealed interface AttachmentChoices :
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrReference,
    FhirChoiceTypes.AttachmentOrReferenceOrString,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice

  public sealed interface Base64BinaryChoices :
    FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.Base64BinaryOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice

  public sealed interface BooleanChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.BooleanOrCanonical,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrCodeableConcept,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrDateTime,
    FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString,
    FhirChoiceTypes.BooleanOrInteger,
    FhirChoiceTypes.BooleanOrReference,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface CanonicalChoices :
    FhirChoiceTypes.BooleanOrCanonical,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice

  public sealed interface CodeableConceptChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.BooleanOrCodeableConcept,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrUri,
    FhirChoiceTypes.CodeableConceptOrDate,
    FhirChoiceTypes.CodeableConceptOrDuration,
    FhirChoiceTypes.CodeableConceptOrQuantity,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrRange,
    FhirChoiceTypes.CodeableConceptOrReference,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.ObservationComponentValueChoice

  public sealed interface CodingChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.CodingOrUri,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DataRequirementChoices :
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice

  public sealed interface DateChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.CodeableConceptOrDate,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateOrDuration,
    FhirChoiceTypes.DateOrPeriod,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DateTimeChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDateTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriod,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DecimalChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DecimalOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DurationChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.CodeableConceptOrDuration,
    FhirChoiceTypes.DateOrDuration,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.DurationOrRange

  public sealed interface ExpressionChoices :
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice

  public sealed interface IdentifierChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice, FhirChoiceTypes.IdentifierOrReference

  public sealed interface InstantChoices :
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice

  public sealed interface IntegerChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString,
    FhirChoiceTypes.BooleanOrInteger,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface MoneyChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.MoneyOrQuantity,
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt,
    FhirChoiceTypes.MoneyOrUnsignedInt

  public sealed interface PeriodChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.DateOrPeriod,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriod,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.PeriodOrRange,
    FhirChoiceTypes.PeriodOrStringOrTiming

  public sealed interface QuantityChoices :
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantity,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.MoneyOrQuantity,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuantityOrRange,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.QuantityOrRangeOrString,
    FhirChoiceTypes.QuantityOrRatio,
    FhirChoiceTypes.QuantityOrString,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface RangeChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrRange,
    FhirChoiceTypes.DecimalOrRange,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.DurationOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.PeriodOrRange,
    FhirChoiceTypes.QuantityOrRange,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.QuantityOrRangeOrString

  public sealed interface RatioChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.QuantityOrRatio

  public sealed interface ReferenceChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.AddressOrReference,
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrReference,
    FhirChoiceTypes.AttachmentOrReferenceOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrReference,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice,
    FhirChoiceTypes.IdentifierOrReference,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice,
    FhirChoiceTypes.ReferenceOrString,
    FhirChoiceTypes.ReferenceOrUrl

  public sealed interface SampledDataChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice

  public sealed interface StringChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrReferenceOrString,
    FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.Base64BinaryOrString,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.DateTimeOrString,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.PeriodOrStringOrTiming,
    FhirChoiceTypes.PositiveIntOrString,
    FhirChoiceTypes.QuantityOrRangeOrRatioOrString,
    FhirChoiceTypes.QuantityOrRangeOrString,
    FhirChoiceTypes.QuantityOrString,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice,
    FhirChoiceTypes.ReferenceOrString

  public sealed interface TimeChoices :
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface TimingChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.PeriodOrStringOrTiming

  public sealed interface TriggerDefinitionChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.EvidenceVariableCharacteristicDefinitionChoice

  public sealed interface UnsignedIntChoices :
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt, FhirChoiceTypes.MoneyOrUnsignedInt

  public sealed interface UriChoices :
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.CodingOrUri,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice
}
