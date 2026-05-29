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

package dev.ohs.fhir.model.r4b

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
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface AgeChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.AgeOrDateTimeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrPeriodOrRangeOrString,
    FhirChoiceTypes.AgeOrRangeOrString

  public sealed interface AnnotationChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface AttachmentChoices :
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrIdentifierOrReferenceOrUri,
    FhirChoiceTypes.AttachmentOrReference,
    FhirChoiceTypes.AttachmentOrReferenceOrString,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.NutritionProductProductCharacteristicValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface Base64BinaryChoices :
    FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.Base64BinaryOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.NutritionProductProductCharacteristicValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface BooleanChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
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
    FhirChoiceTypes.NutritionProductProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface CanonicalChoices :
    FhirChoiceTypes.BooleanOrCanonical,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrExpressionOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrReference

  public sealed interface CodeableConceptChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.Base64BinaryOrCodeableConceptOrQuantityOrString,
    FhirChoiceTypes.BooleanOrCodeableConcept,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrExpressionOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrUri,
    FhirChoiceTypes.CodeableConceptOrDate,
    FhirChoiceTypes.CodeableConceptOrDuration,
    FhirChoiceTypes.CodeableConceptOrQuantity,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRange,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrRange,
    FhirChoiceTypes.CodeableConceptOrReference,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.NutritionProductProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface CodingChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.CodingOrUri,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface ContactDetailChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface ContactPointChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface ContributorChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface DataRequirementChoices :
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface DateChoices :
    FhirChoiceTypes.AgeOrBooleanOrDateOrRangeOrString,
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
    FhirChoiceTypes.CodeableConceptOrDate,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateOrDuration,
    FhirChoiceTypes.DateOrPeriod,
    FhirChoiceTypes.DateOrPeriodOrString,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
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
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DecimalChoices :
    FhirChoiceTypes.BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.BooleanOrDecimalOrIdOrIntegerOrString,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DecimalOrRange,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface DosageChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface DurationChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.CodeableConceptOrDuration,
    FhirChoiceTypes.DateOrDuration,
    FhirChoiceTypes.DateTimeOrDurationOrPeriod,
    FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming,
    FhirChoiceTypes.DurationOrPeriodOrRange,
    FhirChoiceTypes.DurationOrRange,
    FhirChoiceTypes.DurationOrString

  public sealed interface ExpressionChoices :
    FhirChoiceTypes.CanonicalOrCodeableConceptOrDataRequirementOrExpression,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrExpressionOrReference,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface HumanNameChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface IdentifierChoices :
    FhirChoiceTypes.AttachmentOrIdentifierOrReferenceOrUri,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.IdentifierOrReference,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface InstantChoices :
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

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
    FhirChoiceTypes.MoneyOrUnsignedInt,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface ParameterDefinitionChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

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
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.PeriodOrRange,
    FhirChoiceTypes.PeriodOrStringOrTiming

  public sealed interface QuantityChoices :
    FhirChoiceTypes.AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity,
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
    FhirChoiceTypes.NutritionProductProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.QuantityOrRange,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRatio,
    FhirChoiceTypes.QuantityOrRatioOrString,
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
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.PeriodOrRange,
    FhirChoiceTypes.QuantityOrRange,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.RangeOrString

  public sealed interface RatioChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuantityOrRangeOrRatio,
    FhirChoiceTypes.QuantityOrRatio,
    FhirChoiceTypes.QuantityOrRatioOrString,
    FhirChoiceTypes.RatioOrRatioRange

  public sealed interface RatioRangeChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice, FhirChoiceTypes.RatioOrRatioRange

  public sealed interface ReferenceChoices :
    FhirChoiceTypes.AddressOrCodeableConceptOrReference,
    FhirChoiceTypes.AddressOrReference,
    FhirChoiceTypes.AttachmentOrBooleanOrQuantityOrReferenceOrString,
    FhirChoiceTypes.AttachmentOrIdentifierOrReferenceOrUri,
    FhirChoiceTypes.AttachmentOrReference,
    FhirChoiceTypes.AttachmentOrReferenceOrString,
    FhirChoiceTypes.BooleanOrCodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.BooleanOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrExpressionOrReference,
    FhirChoiceTypes.CanonicalOrCodeableConceptOrReference,
    FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference,
    FhirChoiceTypes.CodeableConceptOrReference,
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.IdentifierOrReference,
    FhirChoiceTypes.MarkdownOrReference,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice,
    FhirChoiceTypes.ReferenceOrString,
    FhirChoiceTypes.ReferenceOrUrl

  public sealed interface RelatedArtifactChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface SampledDataChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface SignatureChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

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
    FhirChoiceTypes.DurationOrString,
    FhirChoiceTypes.GoalTargetDetailChoice,
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt,
    FhirChoiceTypes.NutritionProductProductCharacteristicValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.PeriodOrStringOrTiming,
    FhirChoiceTypes.PositiveIntOrString,
    FhirChoiceTypes.QuantityOrRatioOrString,
    FhirChoiceTypes.QuantityOrString,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice,
    FhirChoiceTypes.RangeOrString,
    FhirChoiceTypes.ReferenceOrString

  public sealed interface TimeChoices :
    FhirChoiceTypes.CodingOrDateOrIntegerOrReferenceOrStringOrTime,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ElementDefinitionMaxValueChoice,
    FhirChoiceTypes.ObservationComponentValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.QuestionnaireItemEnableWhenAnswerChoice

  public sealed interface TimingChoices :
    FhirChoiceTypes.AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming,
    FhirChoiceTypes.DateOrDateTimeOrReferenceOrTiming,
    FhirChoiceTypes.DateTimeOrDurationOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrInstantOrPeriodOrTiming,
    FhirChoiceTypes.DateTimeOrPeriodOrTiming,
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice,
    FhirChoiceTypes.PeriodOrStringOrTiming

  public sealed interface TriggerDefinitionChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice

  public sealed interface UnsignedIntChoices :
    FhirChoiceTypes.MoneyOrStringOrUnsignedInt, FhirChoiceTypes.MoneyOrUnsignedInt

  public sealed interface UriChoices :
    FhirChoiceTypes.AttachmentOrIdentifierOrReferenceOrUri,
    FhirChoiceTypes.BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri,
    FhirChoiceTypes.CodingOrUri,
    FhirChoiceTypes.ContractTermOfferAnswerValueChoice

  public sealed interface UsageContextChoices :
    FhirChoiceTypes.ElementDefinitionDefaultValueChoice,
    FhirChoiceTypes.ParametersParameterValueChoice
}
