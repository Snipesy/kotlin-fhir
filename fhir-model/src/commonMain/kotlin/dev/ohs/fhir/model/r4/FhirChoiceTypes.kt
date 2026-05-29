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

import dev.ohs.fhir.model.r4.Address as AddressFhir
import dev.ohs.fhir.model.r4.Age as AgeFhir
import dev.ohs.fhir.model.r4.Annotation as AnnotationFhir
import dev.ohs.fhir.model.r4.Attachment as AttachmentFhir
import dev.ohs.fhir.model.r4.Base64Binary as Base64BinaryFhir
import dev.ohs.fhir.model.r4.Boolean as BooleanFhir
import dev.ohs.fhir.model.r4.Canonical as CanonicalFhir
import dev.ohs.fhir.model.r4.CodeableConcept as CodeableConceptFhir
import dev.ohs.fhir.model.r4.Coding as CodingFhir
import dev.ohs.fhir.model.r4.ContactDetail as ContactDetailFhir
import dev.ohs.fhir.model.r4.ContactPoint as ContactPointFhir
import dev.ohs.fhir.model.r4.Contributor as ContributorFhir
import dev.ohs.fhir.model.r4.DataRequirement as DataRequirementFhir
import dev.ohs.fhir.model.r4.Date as DateFhir
import dev.ohs.fhir.model.r4.DateTime as DateTimeFhir
import dev.ohs.fhir.model.r4.Decimal as DecimalFhir
import dev.ohs.fhir.model.r4.Dosage as DosageFhir
import dev.ohs.fhir.model.r4.Duration as DurationFhir
import dev.ohs.fhir.model.r4.Expression as ExpressionFhir
import dev.ohs.fhir.model.r4.HumanName as HumanNameFhir
import dev.ohs.fhir.model.r4.Identifier as IdentifierFhir
import dev.ohs.fhir.model.r4.Instant as InstantFhir
import dev.ohs.fhir.model.r4.Integer as IntegerFhir
import dev.ohs.fhir.model.r4.Meta as MetaFhir
import dev.ohs.fhir.model.r4.Money as MoneyFhir
import dev.ohs.fhir.model.r4.ParameterDefinition as ParameterDefinitionFhir
import dev.ohs.fhir.model.r4.Period as PeriodFhir
import dev.ohs.fhir.model.r4.PositiveInt as PositiveIntFhir
import dev.ohs.fhir.model.r4.Quantity as QuantityFhir
import dev.ohs.fhir.model.r4.Range as RangeFhir
import dev.ohs.fhir.model.r4.Ratio as RatioFhir
import dev.ohs.fhir.model.r4.Reference as ReferenceFhir
import dev.ohs.fhir.model.r4.RelatedArtifact as RelatedArtifactFhir
import dev.ohs.fhir.model.r4.SampledData as SampledDataFhir
import dev.ohs.fhir.model.r4.Signature as SignatureFhir
import dev.ohs.fhir.model.r4.String as StringFhir
import dev.ohs.fhir.model.r4.Time as TimeFhir
import dev.ohs.fhir.model.r4.Timing as TimingFhir
import dev.ohs.fhir.model.r4.TriggerDefinition as TriggerDefinitionFhir
import dev.ohs.fhir.model.r4.UnsignedInt as UnsignedIntFhir
import dev.ohs.fhir.model.r4.Uri as UriFhir
import dev.ohs.fhir.model.r4.Url as UrlFhir
import dev.ohs.fhir.model.r4.UsageContext as UsageContextFhir

/**
 * GENERATED — not part of the FHIR spec.
 *
 * Every FHIR choice-type ("value[x]") option-set for this version, as a sealed interface namespaced
 * under this object to keep the model package's top-level namespace uncluttered. Each is the type
 * of one or more choice fields; its members implement it directly (bare) or via a top-level
 * `<Type>Box`, and each member is exposed as a nested `typealias`. Match members with plain
 * `is`/`as?`, or the `asX()` extensions in `FhirChoiceExtensions.kt`.
 */
public object FhirChoiceTypes {
  /**
   * A FHIR choice type — one of: [AddressFhir] | [CodeableConceptFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Claim.item.location`
   * - `ClaimResponse.addItem.location`
   * - `ExplanationOfBenefit.addItem.location`
   * - `ExplanationOfBenefit.item.location`
   */
  public sealed interface AddressOrCodeableConceptOrReference {
    public typealias Address = AddressFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [AddressFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Claim.accident.location`
   * - `ExplanationOfBenefit.accident.location`
   */
  public sealed interface AddressOrReference {
    public typealias Address = AddressFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [BooleanFhir] | [DateFhir] | [RangeFhir] |
   * [StringFhir]
   *
   * The choice type for:
   * - `FamilyMemberHistory.deceased`
   */
  public sealed interface AgeOrBooleanOrDateOrRangeOrString {
    public typealias Age = AgeFhir

    public typealias Boolean = BooleanFhir

    public typealias Date = DateFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [DateTimeFhir] | [DurationFhir] | [PeriodFhir] |
   * [RangeFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `ActivityDefinition.timing`
   * - `PlanDefinition.action.timing`
   * - `RequestGroup.action.timing`
   */
  public sealed interface AgeOrDateTimeOrDurationOrPeriodOrRangeOrTiming {
    public typealias Age = AgeFhir

    public typealias DateTime = DateTimeFhir

    public typealias Duration = DurationFhir

    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [DateTimeFhir] | [PeriodFhir] | [RangeFhir] |
   * [StringFhir]
   *
   * The choice type for:
   * - `AllergyIntolerance.onset`
   * - `Condition.abatement`
   * - `Condition.onset`
   * - `Procedure.performed`
   */
  public sealed interface AgeOrDateTimeOrPeriodOrRangeOrString {
    public typealias Age = AgeFhir

    public typealias DateTime = DateTimeFhir

    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [PeriodFhir] | [RangeFhir] | [StringFhir]
   *
   * The choice type for:
   * - `FamilyMemberHistory.condition.onset`
   */
  public sealed interface AgeOrPeriodOrRangeOrString {
    public typealias Age = AgeFhir

    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [RangeFhir] | [StringFhir]
   *
   * The choice type for:
   * - `FamilyMemberHistory.age`
   */
  public sealed interface AgeOrRangeOrString {
    public typealias Age = AgeFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [QuantityFhir] |
   * [ReferenceFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Claim.supportingInfo.value`
   * - `ExplanationOfBenefit.supportingInfo.value`
   */
  public sealed interface AttachmentOrBooleanOrQuantityOrReferenceOrString {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias Quantity = QuantityFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Consent.source`
   * - `Contract.friendly.content`
   * - `Contract.legal.content`
   * - `Contract.legallyBinding`
   * - `Contract.rule.content`
   */
  public sealed interface AttachmentOrReference {
    public typealias Attachment = AttachmentFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [ReferenceFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Communication.payload.content`
   * - `CommunicationRequest.payload.content`
   */
  public sealed interface AttachmentOrReferenceOrString {
    public typealias Attachment = AttachmentFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [Base64BinaryFhir] | [CodeableConceptFhir] | [QuantityFhir] |
   * [StringFhir]
   *
   * The choice type for:
   * - `MedicationKnowledge.drugCharacteristic.value`
   */
  public sealed interface Base64BinaryOrCodeableConceptOrQuantityOrString {
    public typealias Base64Binary = Base64BinaryFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [Base64BinaryFhir] | [StringFhir]
   *
   * The choice type for:
   * - `AuditEvent.entity.detail.value`
   */
  public sealed interface Base64BinaryOrString {
    public typealias Base64Binary = Base64BinaryFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CanonicalFhir]
   *
   * The choice type for:
   * - `ImplementationGuide.definition.resource.example`
   * - `ImplementationGuide.manifest.resource.example`
   */
  public sealed interface BooleanOrCanonical {
    public typealias Boolean = BooleanFhir

    public typealias Canonical = CanonicalFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeBox] | [CodingFhir] | [DateTimeFhir] |
   * [DecimalFhir] | [IntegerFhir] | [StringBox]
   *
   * The choice type for:
   * - `CodeSystem.concept.property.value`
   */
  public sealed interface BooleanOrCodeOrCodingOrDateTimeOrDecimalOrIntegerOrString {
    public typealias Boolean = BooleanFhir

    public typealias Code = CodeBox

    public typealias Coding = CodingFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Integer = IntegerFhir

    public typealias String = StringBox
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeBox] | [DateTimeFhir] | [DecimalFhir] |
   * [IntegerFhir] | [StringBox] | [UriFhir]
   *
   * The choice type for:
   * - `ValueSet.expansion.parameter.value`
   */
  public sealed interface BooleanOrCodeOrDateTimeOrDecimalOrIntegerOrStringOrUri {
    public typealias Boolean = BooleanFhir

    public typealias Code = CodeBox

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Integer = IntegerFhir

    public typealias String = StringBox

    public typealias Uri = UriFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir]
   *
   * The choice type for:
   * - `Dosage.asNeeded`
   * - `MedicationRequest.substitution.allowed`
   * - `ServiceRequest.asNeeded`
   */
  public sealed interface BooleanOrCodeableConcept {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [QuantityFhir] |
   * [RangeFhir]
   *
   * The choice type for:
   * - `DeviceRequest.parameter.value`
   * - `SupplyRequest.parameter.value`
   */
  public sealed interface BooleanOrCodeableConceptOrQuantityOrRange {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [QuantityFhir] |
   * [RangeFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Group.characteristic.value`
   */
  public sealed interface BooleanOrCodeableConceptOrQuantityOrRangeOrReference {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [DateTimeFhir]
   *
   * The choice type for:
   * - `Patient.deceased`
   */
  public sealed interface BooleanOrDateTime {
    public typealias Boolean = BooleanFhir

    public typealias DateTime = DateTimeFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [DecimalFhir] | [IdBox] | [IntegerFhir] |
   * [StringBox]
   *
   * The choice type for:
   * - `StructureMap.group.rule.target.parameter.value`
   */
  public sealed interface BooleanOrDecimalOrIdOrIntegerOrString {
    public typealias Boolean = BooleanFhir

    public typealias Decimal = DecimalFhir

    public typealias Id = IdBox

    public typealias Integer = IntegerFhir

    public typealias String = StringBox
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [IntegerFhir]
   *
   * The choice type for:
   * - `Patient.multipleBirth`
   */
  public sealed interface BooleanOrInteger {
    public typealias Boolean = BooleanFhir

    public typealias Integer = IntegerFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `MedicationRequest.reported`
   */
  public sealed interface BooleanOrReference {
    public typealias Boolean = BooleanFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [CanonicalFhir] | [CodeableConceptFhir] | [DataRequirementFhir] |
   * [ExpressionFhir]
   *
   * The choice type for:
   * - `ResearchElementDefinition.characteristic.definition`
   */
  public sealed interface CanonicalOrCodeableConceptOrDataRequirementOrExpression {
    public typealias Canonical = CanonicalFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DataRequirement = DataRequirementFhir

    public typealias Expression = ExpressionFhir
  }

  /**
   * A FHIR choice type — one of: [CanonicalBox] | [CodeableConceptFhir] | [UriBox]
   *
   * The choice type for:
   * - `GuidanceResponse.module`
   */
  public sealed interface CanonicalOrCodeableConceptOrUri {
    public typealias Canonical = CanonicalBox

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Uri = UriBox
  }

  /**
   * A FHIR choice type — one of: [CanonicalBox] | [UriBox]
   *
   * The choice type for:
   * - `ConceptMap.source`
   * - `ConceptMap.target`
   * - `PlanDefinition.action.definition`
   */
  public sealed interface CanonicalOrUri {
    public typealias Canonical = CanonicalBox

    public typealias Uri = UriBox
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [DateFhir]
   *
   * The choice type for:
   * - `Goal.start`
   */
  public sealed interface CodeableConceptOrDate {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Date = DateFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [DurationFhir]
   *
   * The choice type for:
   * - `Specimen.collection.fastingStatus`
   */
  public sealed interface CodeableConceptOrDuration {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Duration = DurationFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir]
   *
   * The choice type for:
   * - `MedicationKnowledge.administrationGuidelines.patientCharacteristics.characteristic`
   */
  public sealed interface CodeableConceptOrQuantity {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `PlanDefinition.goal.target.detail`
   */
  public sealed interface CodeableConceptOrQuantityOrRange {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir] | [RangeFhir] |
   * [ReferenceFhir]
   *
   * The choice type for:
   * - `UsageContext.value`
   */
  public sealed interface CodeableConceptOrQuantityOrRangeOrReference {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `Population.age`
   */
  public sealed interface CodeableConceptOrRange {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `ActivityDefinition.product`
   * - `ActivityDefinition.subject`
   * - `CarePlan.activity.detail.product`
   * - `ChargeItem.product`
   * - `Claim.diagnosis.diagnosis`
   * - `Claim.procedure.procedure`
   * - `Contract.term.asset.valuedItem.entity`
   * - `Contract.term.topic`
   * - `Contract.topic`
   * - `CoverageEligibilityRequest.item.diagnosis.diagnosis`
   * - `DataRequirement.subject`
   * - `DeviceRequest.code`
   * - `EventDefinition.subject`
   * - `ExplanationOfBenefit.diagnosis.diagnosis`
   * - `ExplanationOfBenefit.procedure.procedure`
   * - `Invoice.lineItem.chargeItem`
   * - `Library.subject`
   * - `Measure.subject`
   * - `Medication.ingredient.item`
   * - `MedicationAdministration.medication`
   * - … and 21 more
   */
  public sealed interface CodeableConceptOrReference {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [CodingFhir] | [DateFhir] | [IntegerFhir] | [ReferenceFhir] |
   * [StringFhir] | [TimeFhir]
   *
   * The choice type for:
   * - `Questionnaire.item.answerOption.value`
   */
  public sealed interface CodingOrDateOrIntegerOrReferenceOrStringOrTime {
    public typealias Coding = CodingFhir

    public typealias Date = DateFhir

    public typealias Integer = IntegerFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir

    public typealias Time = TimeFhir
  }

  /**
   * A FHIR choice type — one of: [CodingFhir] | [UriFhir]
   *
   * The choice type for:
   * - `MessageDefinition.event`
   * - `MessageHeader.event`
   */
  public sealed interface CodingOrUri {
    public typealias Coding = CodingFhir

    public typealias Uri = UriFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodingFhir] | [DateFhir] |
   * [DateTimeFhir] | [DecimalFhir] | [IntegerFhir] | [QuantityFhir] | [ReferenceFhir] |
   * [StringFhir] | [TimeFhir] | [UriFhir]
   *
   * The choice type for:
   * - `Contract.term.offer.answer.value`
   * - `Questionnaire.item.initial.value`
   * - `QuestionnaireResponse.item.answer.value`
   */
  public sealed interface ContractTermOfferAnswerValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias Coding = CodingFhir

    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Integer = IntegerFhir

    public typealias Quantity = QuantityFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir

    public typealias Time = TimeFhir

    public typealias Uri = UriFhir
  }

  /**
   * A FHIR choice type — one of: [DateFhir] | [DateTimeFhir] | [ReferenceFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `TriggerDefinition.timing`
   */
  public sealed interface DateOrDateTimeOrReferenceOrTiming {
    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Reference = ReferenceFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [DateFhir] | [DurationFhir]
   *
   * The choice type for:
   * - `Goal.target.due`
   */
  public sealed interface DateOrDuration {
    public typealias Date = DateFhir

    public typealias Duration = DurationFhir
  }

  /**
   * A FHIR choice type — one of: [DateFhir] | [PeriodFhir]
   *
   * The choice type for:
   * - `Claim.item.serviced`
   * - `Claim.supportingInfo.timing`
   * - `ClaimResponse.addItem.serviced`
   * - `CoverageEligibilityRequest.serviced`
   * - `CoverageEligibilityResponse.serviced`
   * - `ExplanationOfBenefit.addItem.serviced`
   * - `ExplanationOfBenefit.item.serviced`
   * - `ExplanationOfBenefit.supportingInfo.timing`
   */
  public sealed interface DateOrPeriod {
    public typealias Date = DateFhir

    public typealias Period = PeriodFhir
  }

  /**
   * A FHIR choice type — one of: [DateFhir] | [PeriodFhir] | [StringFhir]
   *
   * The choice type for:
   * - `FamilyMemberHistory.born`
   */
  public sealed interface DateOrPeriodOrString {
    public typealias Date = DateFhir

    public typealias Period = PeriodFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [DateTimeFhir] | [DurationFhir] | [PeriodFhir]
   *
   * The choice type for:
   * - `DataRequirement.dateFilter.value`
   */
  public sealed interface DateTimeOrDurationOrPeriod {
    public typealias DateTime = DateTimeFhir

    public typealias Duration = DurationFhir

    public typealias Period = PeriodFhir
  }

  /**
   * A FHIR choice type — one of: [DateTimeFhir] | [DurationFhir] | [PeriodFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `EvidenceVariable.characteristic.participantEffective`
   * - `ResearchElementDefinition.characteristic.participantEffective`
   * - `ResearchElementDefinition.characteristic.studyEffective`
   */
  public sealed interface DateTimeOrDurationOrPeriodOrTiming {
    public typealias DateTime = DateTimeFhir

    public typealias Duration = DurationFhir

    public typealias Period = PeriodFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [DateTimeFhir] | [InstantFhir] | [PeriodFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `Observation.effective`
   */
  public sealed interface DateTimeOrInstantOrPeriodOrTiming {
    public typealias DateTime = DateTimeFhir

    public typealias Instant = InstantFhir

    public typealias Period = PeriodFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [DateTimeFhir] | [PeriodFhir]
   *
   * The choice type for:
   * - `BiologicallyDerivedProduct.collection.collected`
   * - `BiologicallyDerivedProduct.manipulation.time`
   * - `BiologicallyDerivedProduct.processing.time`
   * - `ClinicalImpression.effective`
   * - `CommunicationRequest.occurrence`
   * - `DetectedIssue.identified`
   * - `DiagnosticReport.effective`
   * - `Media.created`
   * - `MedicationAdministration.effective`
   * - `MedicationStatement.effective`
   * - `MedicinalProductAuthorization.procedure.date`
   * - `Provenance.occurred`
   * - `RiskAssessment.occurrence`
   * - `Specimen.collection.collected`
   * - `Specimen.processing.time`
   */
  public sealed interface DateTimeOrPeriod {
    public typealias DateTime = DateTimeFhir

    public typealias Period = PeriodFhir
  }

  /**
   * A FHIR choice type — one of: [DateTimeFhir] | [PeriodFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `ChargeItem.occurrence`
   * - `Contract.term.action.occurrence`
   * - `DeviceRequest.occurrence`
   * - `DeviceUseStatement.timing`
   * - `ServiceRequest.occurrence`
   * - `SupplyDelivery.occurrence`
   * - `SupplyRequest.occurrence`
   */
  public sealed interface DateTimeOrPeriodOrTiming {
    public typealias DateTime = DateTimeFhir

    public typealias Period = PeriodFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [DateTimeFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Immunization.occurrence`
   */
  public sealed interface DateTimeOrString {
    public typealias DateTime = DateTimeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [DecimalFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `RiskAssessment.prediction.probability`
   */
  public sealed interface DecimalOrRange {
    public typealias Decimal = DecimalFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [DurationFhir] | [PeriodFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `Timing.repeat.bounds`
   */
  public sealed interface DurationOrPeriodOrRange {
    public typealias Duration = DurationFhir

    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [DurationFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `PlanDefinition.action.relatedAction.offset`
   * - `RequestGroup.action.relatedAction.offset`
   */
  public sealed interface DurationOrRange {
    public typealias Duration = DurationFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [AddressFhir] | [AgeBox] | [AnnotationFhir] | [AttachmentFhir] |
   * [Base64BinaryFhir] | [BooleanFhir] | [CanonicalBox] | [CodeBox] | [CodeableConceptFhir] |
   * [CodingFhir] | [ContactDetailFhir] | [ContactPointFhir] | [ContributorFhir] | [CountBox] |
   * [DataRequirementFhir] | [DateFhir] | [DateTimeFhir] | [DecimalFhir] | [DistanceBox] |
   * [DosageFhir] | [DurationBox] | [ExpressionFhir] | [HumanNameFhir] | [IdBox] | [IdentifierFhir]
   * | [InstantFhir] | [IntegerBox] | [MarkdownBox] | [MetaFhir] | [MoneyFhir] | [OidBox] |
   * [ParameterDefinitionFhir] | [PeriodFhir] | [PositiveIntBox] | [QuantityBox] | [RangeFhir] |
   * [RatioFhir] | [ReferenceFhir] | [RelatedArtifactFhir] | [SampledDataFhir] | [SignatureFhir] |
   * [StringBox] | [TimeFhir] | [TimingFhir] | [TriggerDefinitionFhir] | [UnsignedIntBox] | [UriBox]
   * | [UrlBox] | [UsageContextFhir] | [UuidBox]
   *
   * The choice type for:
   * - `ElementDefinition.defaultValue`
   * - `ElementDefinition.example.value`
   * - `ElementDefinition.fixed`
   * - `ElementDefinition.pattern`
   * - `Extension.value`
   * - `Parameters.parameter.value`
   * - `StructureMap.group.rule.source.defaultValue`
   * - `Task.input.value`
   * - `Task.output.value`
   */
  public sealed interface ElementDefinitionDefaultValueChoice {
    public typealias Address = AddressFhir

    public typealias Age = AgeBox

    public typealias Annotation = AnnotationFhir

    public typealias Attachment = AttachmentFhir

    public typealias Base64Binary = Base64BinaryFhir

    public typealias Boolean = BooleanFhir

    public typealias Canonical = CanonicalBox

    public typealias Code = CodeBox

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Coding = CodingFhir

    public typealias ContactDetail = ContactDetailFhir

    public typealias ContactPoint = ContactPointFhir

    public typealias Contributor = ContributorFhir

    public typealias Count = CountBox

    public typealias DataRequirement = DataRequirementFhir

    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Distance = DistanceBox

    public typealias Dosage = DosageFhir

    public typealias Duration = DurationBox

    public typealias Expression = ExpressionFhir

    public typealias HumanName = HumanNameFhir

    public typealias Id = IdBox

    public typealias Identifier = IdentifierFhir

    public typealias Instant = InstantFhir

    public typealias Integer = IntegerBox

    public typealias Markdown = MarkdownBox

    public typealias Meta = MetaFhir

    public typealias Money = MoneyFhir

    public typealias Oid = OidBox

    public typealias ParameterDefinition = ParameterDefinitionFhir

    public typealias Period = PeriodFhir

    public typealias PositiveInt = PositiveIntBox

    public typealias Quantity = QuantityBox

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias Reference = ReferenceFhir

    public typealias RelatedArtifact = RelatedArtifactFhir

    public typealias SampledData = SampledDataFhir

    public typealias Signature = SignatureFhir

    public typealias String = StringBox

    public typealias Time = TimeFhir

    public typealias Timing = TimingFhir

    public typealias TriggerDefinition = TriggerDefinitionFhir

    public typealias UnsignedInt = UnsignedIntBox

    public typealias Uri = UriBox

    public typealias Url = UrlBox

    public typealias UsageContext = UsageContextFhir

    public typealias Uuid = UuidBox
  }

  /**
   * A FHIR choice type — one of: [DateFhir] | [DateTimeFhir] | [DecimalFhir] | [InstantFhir] |
   * [IntegerBox] | [PositiveIntBox] | [QuantityFhir] | [TimeFhir] | [UnsignedIntBox]
   *
   * The choice type for:
   * - `ElementDefinition.maxValue`
   * - `ElementDefinition.minValue`
   */
  public sealed interface ElementDefinitionMaxValueChoice {
    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Instant = InstantFhir

    public typealias Integer = IntegerBox

    public typealias PositiveInt = PositiveIntBox

    public typealias Quantity = QuantityFhir

    public typealias Time = TimeFhir

    public typealias UnsignedInt = UnsignedIntBox
  }

  /**
   * A FHIR choice type — one of: [CanonicalFhir] | [CodeableConceptFhir] | [DataRequirementFhir] |
   * [ExpressionFhir] | [ReferenceFhir] | [TriggerDefinitionFhir]
   *
   * The choice type for:
   * - `EvidenceVariable.characteristic.definition`
   */
  public sealed interface EvidenceVariableCharacteristicDefinitionChoice {
    public typealias Canonical = CanonicalFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DataRequirement = DataRequirementFhir

    public typealias Expression = ExpressionFhir

    public typealias Reference = ReferenceFhir

    public typealias TriggerDefinition = TriggerDefinitionFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [IntegerFhir] |
   * [QuantityFhir] | [RangeFhir] | [RatioFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Goal.target.detail`
   */
  public sealed interface GoalTargetDetailChoice {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Integer = IntegerFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [IdentifierFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Composition.relatesTo.target`
   */
  public sealed interface IdentifierOrReference {
    public typealias Identifier = IdentifierFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [MoneyFhir] | [QuantityFhir]
   *
   * The choice type for:
   * - `Coverage.costToBeneficiary.value`
   */
  public sealed interface MoneyOrQuantity {
    public typealias Money = MoneyFhir

    public typealias Quantity = QuantityFhir
  }

  /**
   * A FHIR choice type — one of: [MoneyFhir] | [StringFhir] | [UnsignedIntFhir]
   *
   * The choice type for:
   * - `CoverageEligibilityResponse.insurance.item.benefit.allowed`
   * - `CoverageEligibilityResponse.insurance.item.benefit.used`
   * - `ExplanationOfBenefit.benefitBalance.financial.allowed`
   */
  public sealed interface MoneyOrStringOrUnsignedInt {
    public typealias Money = MoneyFhir

    public typealias String = StringFhir

    public typealias UnsignedInt = UnsignedIntFhir
  }

  /**
   * A FHIR choice type — one of: [MoneyFhir] | [UnsignedIntFhir]
   *
   * The choice type for:
   * - `ExplanationOfBenefit.benefitBalance.financial.used`
   */
  public sealed interface MoneyOrUnsignedInt {
    public typealias Money = MoneyFhir

    public typealias UnsignedInt = UnsignedIntFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [DateTimeFhir] |
   * [IntegerFhir] | [PeriodFhir] | [QuantityFhir] | [RangeFhir] | [RatioFhir] | [SampledDataFhir] |
   * [StringFhir] | [TimeFhir]
   *
   * The choice type for:
   * - `Observation.component.value`
   * - `Observation.value`
   */
  public sealed interface ObservationComponentValueChoice {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DateTime = DateTimeFhir

    public typealias Integer = IntegerFhir

    public typealias Period = PeriodFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias SampledData = SampledDataFhir

    public typealias String = StringFhir

    public typealias Time = TimeFhir
  }

  /**
   * A FHIR choice type — one of: [PeriodFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `RiskAssessment.prediction.when`
   */
  public sealed interface PeriodOrRange {
    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [PeriodFhir] | [StringFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `CarePlan.activity.detail.scheduled`
   */
  public sealed interface PeriodOrStringOrTiming {
    public typealias Period = PeriodFhir

    public typealias String = StringFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [PositiveIntFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Immunization.protocolApplied.doseNumber`
   * - `Immunization.protocolApplied.seriesDoses`
   * - `ImmunizationEvaluation.doseNumber`
   * - `ImmunizationEvaluation.seriesDoses`
   * - `ImmunizationRecommendation.recommendation.doseNumber`
   * - `ImmunizationRecommendation.recommendation.seriesDoses`
   */
  public sealed interface PositiveIntOrString {
    public typealias PositiveInt = PositiveIntFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `Dosage.doseAndRate.dose`
   */
  public sealed interface QuantityOrRange {
    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RangeFhir] | [RatioFhir]
   *
   * The choice type for:
   * - `Dosage.doseAndRate.rate`
   * - `ServiceRequest.quantity`
   */
  public sealed interface QuantityOrRangeOrRatio {
    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RangeFhir] | [RatioFhir] | [StringFhir]
   *
   * The choice type for:
   * - `SubstanceSpecification.relationship.amount`
   */
  public sealed interface QuantityOrRangeOrRatioOrString {
    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RangeFhir] | [StringFhir]
   *
   * The choice type for:
   * - `SubstanceAmount.amount`
   * - `SubstanceReferenceInformation.target.amount`
   */
  public sealed interface QuantityOrRangeOrString {
    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RatioFhir]
   *
   * The choice type for:
   * - `MedicationAdministration.dosage.rate`
   * - `NutritionOrder.enteralFormula.administration.rate`
   */
  public sealed interface QuantityOrRatio {
    public typealias Quantity = QuantityFhir

    public typealias Ratio = RatioFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [StringFhir]
   *
   * The choice type for:
   * - `SpecimenDefinition.typeTested.container.minimumVolume`
   * - `SubstanceSpecification.moiety.amount`
   * - `SubstanceSpecification.property.amount`
   */
  public sealed interface QuantityOrString {
    public typealias Quantity = QuantityFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodingFhir] | [DateFhir] | [DateTimeFhir] |
   * [DecimalFhir] | [IntegerFhir] | [QuantityFhir] | [ReferenceFhir] | [StringFhir] | [TimeFhir]
   *
   * The choice type for:
   * - `Questionnaire.item.enableWhen.answer`
   */
  public sealed interface QuestionnaireItemEnableWhenAnswerChoice {
    public typealias Boolean = BooleanFhir

    public typealias Coding = CodingFhir

    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Integer = IntegerFhir

    public typealias Quantity = QuantityFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir

    public typealias Time = TimeFhir
  }

  /**
   * A FHIR choice type — one of: [ReferenceFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Annotation.author`
   * - `DeviceDefinition.manufacturer`
   */
  public sealed interface ReferenceOrString {
    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [ReferenceFhir] | [UrlFhir]
   *
   * The choice type for:
   * - `ImplementationGuide.definition.page.name`
   */
  public sealed interface ReferenceOrUrl {
    public typealias Reference = ReferenceFhir

    public typealias Url = UrlFhir
  }
}
