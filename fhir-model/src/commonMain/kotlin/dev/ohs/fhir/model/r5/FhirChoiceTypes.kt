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

import dev.ohs.fhir.model.r5.Address as AddressFhir
import dev.ohs.fhir.model.r5.Age as AgeFhir
import dev.ohs.fhir.model.r5.Annotation as AnnotationFhir
import dev.ohs.fhir.model.r5.Attachment as AttachmentFhir
import dev.ohs.fhir.model.r5.Availability as AvailabilityFhir
import dev.ohs.fhir.model.r5.Base64Binary as Base64BinaryFhir
import dev.ohs.fhir.model.r5.Boolean as BooleanFhir
import dev.ohs.fhir.model.r5.Canonical as CanonicalFhir
import dev.ohs.fhir.model.r5.CodeableConcept as CodeableConceptFhir
import dev.ohs.fhir.model.r5.CodeableReference as CodeableReferenceFhir
import dev.ohs.fhir.model.r5.Coding as CodingFhir
import dev.ohs.fhir.model.r5.ContactDetail as ContactDetailFhir
import dev.ohs.fhir.model.r5.ContactPoint as ContactPointFhir
import dev.ohs.fhir.model.r5.DataRequirement as DataRequirementFhir
import dev.ohs.fhir.model.r5.Date as DateFhir
import dev.ohs.fhir.model.r5.DateTime as DateTimeFhir
import dev.ohs.fhir.model.r5.Decimal as DecimalFhir
import dev.ohs.fhir.model.r5.Dosage as DosageFhir
import dev.ohs.fhir.model.r5.Duration as DurationFhir
import dev.ohs.fhir.model.r5.Expression as ExpressionFhir
import dev.ohs.fhir.model.r5.ExtendedContactDetail as ExtendedContactDetailFhir
import dev.ohs.fhir.model.r5.HumanName as HumanNameFhir
import dev.ohs.fhir.model.r5.Id as IdFhir
import dev.ohs.fhir.model.r5.Identifier as IdentifierFhir
import dev.ohs.fhir.model.r5.Instant as InstantFhir
import dev.ohs.fhir.model.r5.Integer as IntegerFhir
import dev.ohs.fhir.model.r5.Integer64 as Integer64Fhir
import dev.ohs.fhir.model.r5.Markdown as MarkdownFhir
import dev.ohs.fhir.model.r5.Meta as MetaFhir
import dev.ohs.fhir.model.r5.Money as MoneyFhir
import dev.ohs.fhir.model.r5.ParameterDefinition as ParameterDefinitionFhir
import dev.ohs.fhir.model.r5.Period as PeriodFhir
import dev.ohs.fhir.model.r5.PositiveInt as PositiveIntFhir
import dev.ohs.fhir.model.r5.Quantity as QuantityFhir
import dev.ohs.fhir.model.r5.Range as RangeFhir
import dev.ohs.fhir.model.r5.Ratio as RatioFhir
import dev.ohs.fhir.model.r5.RatioRange as RatioRangeFhir
import dev.ohs.fhir.model.r5.Reference as ReferenceFhir
import dev.ohs.fhir.model.r5.RelatedArtifact as RelatedArtifactFhir
import dev.ohs.fhir.model.r5.SampledData as SampledDataFhir
import dev.ohs.fhir.model.r5.Signature as SignatureFhir
import dev.ohs.fhir.model.r5.String as StringFhir
import dev.ohs.fhir.model.r5.Time as TimeFhir
import dev.ohs.fhir.model.r5.Timing as TimingFhir
import dev.ohs.fhir.model.r5.TriggerDefinition as TriggerDefinitionFhir
import dev.ohs.fhir.model.r5.UnsignedInt as UnsignedIntFhir
import dev.ohs.fhir.model.r5.Uri as UriFhir
import dev.ohs.fhir.model.r5.Url as UrlFhir
import dev.ohs.fhir.model.r5.UsageContext as UsageContextFhir

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
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [DateFhir] | [MarkdownFhir] | [QuantityFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `AdministrableProductDefinition.property.value`
   * - `ManufacturedItemDefinition.property.value`
   */
  public sealed interface AdministrableProductDefinitionPropertyValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Date = DateFhir

    public typealias Markdown = MarkdownFhir

    public typealias Quantity = QuantityFhir

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
   * - `RequestOrchestration.action.timing`
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
   * - `FamilyMemberHistory.procedure.performed`
   */
  public sealed interface AgeOrDateTimeOrPeriodOrRangeOrString {
    public typealias Age = AgeFhir

    public typealias DateTime = DateTimeFhir

    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [DateTimeFhir] | [PeriodFhir] | [RangeFhir] |
   * [StringFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `Procedure.occurrence`
   */
  public sealed interface AgeOrDateTimeOrPeriodOrRangeOrStringOrTiming {
    public typealias Age = AgeFhir

    public typealias DateTime = DateTimeFhir

    public typealias Period = PeriodFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [AgeFhir] | [DurationFhir] | [RangeFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `ActivityDefinition.timing`
   * - `PlanDefinition.action.timing`
   */
  public sealed interface AgeOrDurationOrRangeOrTiming {
    public typealias Age = AgeFhir

    public typealias Duration = DurationFhir

    public typealias Range = RangeFhir

    public typealias Timing = TimingFhir
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
   * A FHIR choice type — one of: [AttachmentFhir] | [Base64BinaryFhir] | [CodeableConceptFhir] |
   * [QuantityFhir] | [StringFhir]
   *
   * The choice type for:
   * - `MedicationKnowledge.definitional.drugCharacteristic.value`
   */
  public sealed interface AttachmentOrBase64BinaryOrCodeableConceptOrQuantityOrString {
    public typealias Attachment = AttachmentFhir

    public typealias Base64Binary = Base64BinaryFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [DateFhir] | [QuantityFhir]
   *
   * The choice type for:
   * - `PackagedProductDefinition.packaging.property.value`
   * - `SubstanceDefinition.property.value`
   */
  public sealed interface AttachmentOrBooleanOrCodeableConceptOrDateOrQuantity {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Date = DateFhir

    public typealias Quantity = QuantityFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [IdentifierFhir] |
   * [QuantityFhir] | [ReferenceFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Claim.supportingInfo.value`
   * - `ExplanationOfBenefit.supportingInfo.value`
   */
  public sealed interface AttachmentOrBooleanOrIdentifierOrQuantityOrReferenceOrString {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias Identifier = IdentifierFhir

    public typealias Quantity = QuantityFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [CodeableConceptFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Communication.payload.content`
   * - `CommunicationRequest.payload.content`
   */
  public sealed interface AttachmentOrCodeableConceptOrReference {
    public typealias Attachment = AttachmentFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [ReferenceFhir]
   *
   * The choice type for:
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
   * A FHIR choice type — one of: [Base64BinaryFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [DateTimeFhir] | [IntegerFhir] | [PeriodFhir] | [QuantityFhir] | [RangeFhir] | [RatioFhir] |
   * [StringFhir] | [TimeFhir]
   *
   * The choice type for:
   * - `AuditEvent.entity.detail.value`
   */
  public sealed interface AuditEventEntityDetailValueChoice {
    public typealias Base64Binary = Base64BinaryFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DateTime = DateTimeFhir

    public typealias Integer = IntegerFhir

    public typealias Period = PeriodFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir

    public typealias Time = TimeFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [IntegerFhir] | [PeriodFhir] | [QuantityFhir] | [RangeFhir] | [RatioFhir] | [StringFhir]
   *
   * The choice type for:
   * - `BiologicallyDerivedProduct.property.value`
   */
  public sealed interface BiologicallyDerivedProductPropertyValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Integer = IntegerFhir

    public typealias Period = PeriodFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeBox] | [CodingFhir] | [DateTimeFhir] |
   * [DecimalFhir] | [IntegerFhir] | [StringBox]
   *
   * The choice type for:
   * - `CodeSystem.concept.property.value`
   * - `ConceptMap.group.element.target.property.value`
   * - `ValueSet.expansion.contains.property.subProperty.value`
   * - `ValueSet.expansion.contains.property.value`
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
   * A FHIR choice type — one of: [BooleanFhir] | [CodeBox] | [CodingFhir] | [QuantityFhir] |
   * [StringBox]
   *
   * The choice type for:
   * - `ConceptMap.group.element.target.dependsOn.value`
   */
  public sealed interface BooleanOrCodeOrCodingOrQuantityOrString {
    public typealias Boolean = BooleanFhir

    public typealias Code = CodeBox

    public typealias Coding = CodingFhir

    public typealias Quantity = QuantityFhir

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
   * - `ActivityDefinition.asNeeded`
   * - `MedicationRequest.substitution.allowed`
   * - `PlanDefinition.asNeeded`
   * - `ServiceRequest.asNeeded`
   */
  public sealed interface BooleanOrCodeableConcept {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [IdFhir] | [QuantityFhir]
   * | [RangeFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `EvidenceVariable.characteristic.definitionByTypeAndValue.value`
   */
  public sealed interface BooleanOrCodeableConceptOrIdOrQuantityOrRangeOrReference {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Id = IdFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [PeriodFhir] |
   * [QuantityFhir] | [RangeFhir] | [RatioFhir] | [StringFhir]
   *
   * The choice type for:
   * - `ServiceRequest.orderDetail.parameter.value`
   */
  public sealed interface BooleanOrCodeableConceptOrPeriodOrQuantityOrRangeOrRatioOrString {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Period = PeriodFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir
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
   * - `EvidenceReport.subject.characteristic.value`
   * - `Group.characteristic.value`
   * - `MeasureReport.group.stratifier.stratum.component.value`
   * - `MeasureReport.group.stratifier.stratum.value`
   */
  public sealed interface BooleanOrCodeableConceptOrQuantityOrRangeOrReference {
    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [DateFhir] | [DateTimeFhir] | [DecimalFhir] |
   * [IdBox] | [IntegerFhir] | [StringBox] | [TimeFhir]
   *
   * The choice type for:
   * - `StructureMap.group.rule.target.parameter.value`
   */
  public sealed interface BooleanOrDateOrDateTimeOrDecimalOrIdOrIntegerOrStringOrTime {
    public typealias Boolean = BooleanFhir

    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Id = IdBox

    public typealias Integer = IntegerFhir

    public typealias String = StringBox

    public typealias Time = TimeFhir
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [DateTimeFhir]
   *
   * The choice type for:
   * - `Patient.deceased`
   * - `Person.deceased`
   * - `Practitioner.deceased`
   */
  public sealed interface BooleanOrDateTime {
    public typealias Boolean = BooleanFhir

    public typealias DateTime = DateTimeFhir
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
   * - `NutritionIntake.reported`
   * - `Procedure.reported`
   */
  public sealed interface BooleanOrReference {
    public typealias Boolean = BooleanFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [CanonicalFhir] | [CodeableConceptFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `ActivityDefinition.subject`
   * - `PlanDefinition.action.subject`
   * - `PlanDefinition.subject`
   */
  public sealed interface CanonicalOrCodeableConceptOrReference {
    public typealias Canonical = CanonicalFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Reference = ReferenceFhir
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
   * A FHIR choice type — one of: [CanonicalFhir] | [CodingFhir]
   *
   * The choice type for:
   * - `MessageHeader.event`
   */
  public sealed interface CanonicalOrCoding {
    public typealias Canonical = CanonicalFhir

    public typealias Coding = CodingFhir
  }

  /**
   * A FHIR choice type — one of: [CanonicalBox] | [CodingFhir] | [UriBox]
   *
   * The choice type for:
   * - `DocumentReference.content.profile.value`
   */
  public sealed interface CanonicalOrCodingOrUri {
    public typealias Canonical = CanonicalBox

    public typealias Coding = CodingFhir

    public typealias Uri = UriBox
  }

  /**
   * A FHIR choice type — one of: [CanonicalFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `Observation.instantiates`
   * - `RequestOrchestration.action.participant.actor`
   */
  public sealed interface CanonicalOrReference {
    public typealias Canonical = CanonicalFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [CanonicalBox] | [ReferenceFhir] | [UriBox]
   *
   * The choice type for:
   * - `ArtifactAssessment.artifact`
   */
  public sealed interface CanonicalOrReferenceOrUri {
    public typealias Canonical = CanonicalBox

    public typealias Reference = ReferenceFhir

    public typealias Uri = UriBox
  }

  /**
   * A FHIR choice type — one of: [CanonicalBox] | [UriBox]
   *
   * The choice type for:
   * - `ConceptMap.sourceScope`
   * - `ConceptMap.targetScope`
   * - `ExampleScenario.instance.structureProfile`
   * - `PlanDefinition.action.definition`
   * - `RequestOrchestration.action.definition`
   * - `TestReport.setup.action.assert.requirement.link`
   * - `TestScript.setup.action.assert.requirement.link`
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
   * A FHIR choice type — one of: [CodeableConceptFhir] | [DateTimeFhir] | [DurationBox] |
   * [PeriodFhir] | [QuantityBox] | [RangeFhir]
   *
   * The choice type for:
   * - `MeasureReport.group.measureScore`
   * - `MeasureReport.group.stratifier.stratum.measureScore`
   */
  public sealed interface CodeableConceptOrDateTimeOrDurationOrPeriodOrQuantityOrRange {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DateTime = DateTimeFhir

    public typealias Duration = DurationBox

    public typealias Period = PeriodFhir

    public typealias Quantity = QuantityBox

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [DateTimeFhir] | [IdFhir] |
   * [ReferenceFhir]
   *
   * The choice type for:
   * - `EvidenceVariable.characteristic.timeFromEvent.event`
   */
  public sealed interface CodeableConceptOrDateTimeOrIdOrReference {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DateTime = DateTimeFhir

    public typealias Id = IdFhir

    public typealias Reference = ReferenceFhir
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
   * A FHIR choice type — one of: [CodeableConceptFhir] | [MoneyFhir]
   *
   * The choice type for:
   * - `MedicationKnowledge.cost.cost`
   */
  public sealed interface CodeableConceptOrMoney {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Money = MoneyFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir]
   *
   * The choice type for:
   * - `ConditionDefinition.precondition.value`
   */
  public sealed interface CodeableConceptOrQuantity {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `EvidenceVariable.category.value`
   * - `MedicationKnowledge.indicationGuideline.dosingGuideline.patientCharacteristic.value`
   * - `MedicationKnowledge.storageGuideline.environmentalSetting.value`
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
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir] | [RatioFhir]
   *
   * The choice type for:
   * - `Medication.ingredient.strength`
   * - `MedicationKnowledge.definitional.ingredient.strength`
   */
  public sealed interface CodeableConceptOrQuantityOrRatio {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Ratio = RatioFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [QuantityFhir] | [RatioFhir] |
   * [RatioRangeFhir]
   *
   * The choice type for:
   * - `Ingredient.substance.strength.concentration`
   * - `Ingredient.substance.strength.presentation`
   */
  public sealed interface CodeableConceptOrQuantityOrRatioOrRatioRange {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias Ratio = RatioFhir

    public typealias RatioRange = RatioRangeFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `ActivityDefinition.product`
   * - `AdverseEvent.contributingFactor.item`
   * - `AdverseEvent.mitigatingAction.item`
   * - `AdverseEvent.preventiveAction.item`
   * - `AdverseEvent.supportingInfo.item`
   * - `AdverseEvent.suspectEntity.instance`
   * - `Claim.diagnosis.diagnosis`
   * - `Claim.procedure.procedure`
   * - `ClinicalUseDefinition.interaction.interactant.item`
   * - `Contract.term.asset.valuedItem.entity`
   * - `Contract.term.topic`
   * - `Contract.topic`
   * - `CoverageEligibilityRequest.item.diagnosis.diagnosis`
   * - `DataRequirement.subject`
   * - `EventDefinition.subject`
   * - `ExplanationOfBenefit.diagnosis.diagnosis`
   * - `ExplanationOfBenefit.procedure.procedure`
   * - `Invoice.lineItem.chargeItem`
   * - `Library.subject`
   * - `Measure.group.subject`
   * - … and 6 more
   */
  public sealed interface CodeableConceptOrReference {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [CodeableConceptFhir] | [ReferenceFhir] | [StringFhir]
   *
   * The choice type for:
   * - `MolecularSequence.relative.startingSequence.sequence`
   */
  public sealed interface CodeableConceptOrReferenceOrString {
    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir
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
   * A FHIR choice type — one of: [CodingFhir] | [StringFhir]
   *
   * The choice type for:
   * - `ActivityDefinition.versionAlgorithm`
   * - `ActorDefinition.versionAlgorithm`
   * - `CapabilityStatement.versionAlgorithm`
   * - `ChargeItemDefinition.versionAlgorithm`
   * - `Citation.versionAlgorithm`
   * - `CodeSystem.versionAlgorithm`
   * - `CompartmentDefinition.versionAlgorithm`
   * - `ConceptMap.versionAlgorithm`
   * - `ConditionDefinition.versionAlgorithm`
   * - `EventDefinition.versionAlgorithm`
   * - `Evidence.versionAlgorithm`
   * - `EvidenceVariable.versionAlgorithm`
   * - `ExampleScenario.versionAlgorithm`
   * - `GraphDefinition.versionAlgorithm`
   * - `ImplementationGuide.versionAlgorithm`
   * - `Library.versionAlgorithm`
   * - `Measure.versionAlgorithm`
   * - `MessageDefinition.versionAlgorithm`
   * - `NamingSystem.versionAlgorithm`
   * - `ObservationDefinition.versionAlgorithm`
   * - … and 13 more
   */
  public sealed interface CodingOrString {
    public typealias Coding = CodingFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [CodingFhir] | [UriFhir]
   *
   * The choice type for:
   * - `MessageDefinition.event`
   */
  public sealed interface CodingOrUri {
    public typealias Coding = CodingFhir

    public typealias Uri = UriFhir
  }

  /**
   * A FHIR choice type — one of: [ContactPointFhir] | [ExtendedContactDetailFhir] | [StringFhir] |
   * [UrlFhir]
   *
   * The choice type for:
   * - `VirtualServiceDetail.address`
   */
  public sealed interface ContactPointOrExtendedContactDetailOrStringOrUrl {
    public typealias ContactPoint = ContactPointFhir

    public typealias ExtendedContactDetail = ExtendedContactDetailFhir

    public typealias String = StringFhir

    public typealias Url = UrlFhir
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
   * - `Invoice.lineItem.serviced`
   * - `Invoice.period`
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
   * - `DataRequirement.valueFilter.value`
   */
  public sealed interface DateTimeOrDurationOrPeriod {
    public typealias DateTime = DateTimeFhir

    public typealias Duration = DurationFhir

    public typealias Period = PeriodFhir
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
   * - `AuditEvent.occurred`
   * - `BiologicallyDerivedProduct.collection.collected`
   * - `Claim.event.when`
   * - `ClaimResponse.event.when`
   * - `ClinicalImpression.effective`
   * - `CommunicationRequest.occurrence`
   * - `CoverageEligibilityRequest.event.when`
   * - `CoverageEligibilityResponse.event.when`
   * - `DetectedIssue.identified`
   * - `DiagnosticReport.effective`
   * - `ExplanationOfBenefit.event.when`
   * - `NutritionIntake.occurrence`
   * - `Provenance.occurred`
   * - `RegulatedAuthorization.case.date`
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
   * - `AdverseEvent.occurrence`
   * - `ChargeItem.occurrence`
   * - `Contract.term.action.occurrence`
   * - `DeviceRequest.occurrence`
   * - `DeviceUsage.timing`
   * - `MedicationAdministration.occurence`
   * - `MedicationStatement.effective`
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
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [IntegerFhir] | [QuantityFhir] | [RangeFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Device.property.value`
   * - `DeviceDefinition.property.value`
   */
  public sealed interface DevicePropertyValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Integer = IntegerFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias String = StringFhir
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
   * - `RequestOrchestration.action.relatedAction.offset`
   */
  public sealed interface DurationOrRange {
    public typealias Duration = DurationFhir

    public typealias Range = RangeFhir
  }

  /**
   * A FHIR choice type — one of: [DurationFhir] | [StringFhir]
   *
   * The choice type for:
   * - `ProductShelfLife.period`
   */
  public sealed interface DurationOrString {
    public typealias Duration = DurationFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AddressFhir] | [AgeBox] | [AnnotationFhir] | [AttachmentFhir] |
   * [AvailabilityFhir] | [Base64BinaryFhir] | [BooleanFhir] | [CanonicalBox] | [CodeBox] |
   * [CodeableConceptFhir] | [CodeableReferenceFhir] | [CodingFhir] | [ContactDetailFhir] |
   * [ContactPointFhir] | [CountBox] | [DataRequirementFhir] | [DateFhir] | [DateTimeFhir] |
   * [DecimalFhir] | [DistanceBox] | [DosageFhir] | [DurationBox] | [ExpressionFhir] |
   * [ExtendedContactDetailFhir] | [HumanNameFhir] | [IdBox] | [IdentifierFhir] | [InstantFhir] |
   * [IntegerBox] | [Integer64Fhir] | [MarkdownBox] | [MetaFhir] | [MoneyFhir] | [OidBox] |
   * [ParameterDefinitionFhir] | [PeriodFhir] | [PositiveIntBox] | [QuantityBox] | [RangeFhir] |
   * [RatioFhir] | [RatioRangeFhir] | [ReferenceFhir] | [RelatedArtifactFhir] | [SampledDataFhir] |
   * [SignatureFhir] | [StringBox] | [TimeFhir] | [TimingFhir] | [TriggerDefinitionFhir] |
   * [UnsignedIntBox] | [UriBox] | [UrlBox] | [UsageContextFhir] | [UuidBox]
   *
   * The choice type for:
   * - `ElementDefinition.defaultValue`
   * - `ElementDefinition.example.value`
   * - `ElementDefinition.fixed`
   * - `ElementDefinition.pattern`
   * - `Extension.value`
   * - `Parameters.parameter.value`
   * - `Task.input.value`
   * - `Task.output.value`
   * - `Transport.input.value`
   * - `Transport.output.value`
   */
  public sealed interface ElementDefinitionDefaultValueChoice {
    public typealias Address = AddressFhir

    public typealias Age = AgeBox

    public typealias Annotation = AnnotationFhir

    public typealias Attachment = AttachmentFhir

    public typealias Availability = AvailabilityFhir

    public typealias Base64Binary = Base64BinaryFhir

    public typealias Boolean = BooleanFhir

    public typealias Canonical = CanonicalBox

    public typealias Code = CodeBox

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias CodeableReference = CodeableReferenceFhir

    public typealias Coding = CodingFhir

    public typealias ContactDetail = ContactDetailFhir

    public typealias ContactPoint = ContactPointFhir

    public typealias Count = CountBox

    public typealias DataRequirement = DataRequirementFhir

    public typealias Date = DateFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Distance = DistanceBox

    public typealias Dosage = DosageFhir

    public typealias Duration = DurationBox

    public typealias Expression = ExpressionFhir

    public typealias ExtendedContactDetail = ExtendedContactDetailFhir

    public typealias HumanName = HumanNameFhir

    public typealias Id = IdBox

    public typealias Identifier = IdentifierFhir

    public typealias Instant = InstantFhir

    public typealias Integer = IntegerBox

    public typealias Integer64 = Integer64Fhir

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

    public typealias RatioRange = RatioRangeFhir

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
   * [IntegerBox] | [Integer64Fhir] | [PositiveIntBox] | [QuantityFhir] | [TimeFhir] |
   * [UnsignedIntBox]
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

    public typealias Integer64 = Integer64Fhir

    public typealias PositiveInt = PositiveIntBox

    public typealias Quantity = QuantityFhir

    public typealias Time = TimeFhir

    public typealias UnsignedInt = UnsignedIntBox
  }

  /**
   * A FHIR choice type — one of: [BooleanFhir] | [CodeableConceptFhir] | [IntegerFhir] |
   * [QuantityFhir] | [RangeFhir] | [RatioFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Goal.target.detail`
   * - `PlanDefinition.goal.target.detail`
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
   * A FHIR choice type — one of: [IdentifierFhir] | [PositiveIntFhir] | [StringFhir]
   *
   * The choice type for:
   * - `PaymentReconciliation.allocation.targetItem`
   */
  public sealed interface IdentifierOrPositiveIntOrString {
    public typealias Identifier = IdentifierFhir

    public typealias PositiveInt = PositiveIntFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [IdentifierFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `GenomicStudy.analysis.input.generatedBy`
   */
  public sealed interface IdentifierOrReference {
    public typealias Identifier = IdentifierFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [AddressFhir] | [AnnotationFhir] | [BooleanFhir] |
   * [CodeableConceptFhir] | [DateTimeFhir] | [DecimalFhir] | [DurationBox] | [IntegerFhir] |
   * [QuantityBox] | [RangeFhir] | [RatioFhir] | [StringFhir] | [UrlFhir]
   *
   * The choice type for:
   * - `InventoryItem.characteristic.value`
   */
  public sealed interface InventoryItemCharacteristicValueChoice {
    public typealias Address = AddressFhir

    public typealias Annotation = AnnotationFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DateTime = DateTimeFhir

    public typealias Decimal = DecimalFhir

    public typealias Duration = DurationBox

    public typealias Integer = IntegerFhir

    public typealias Quantity = QuantityBox

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir

    public typealias Url = UrlFhir
  }

  /**
   * A FHIR choice type — one of: [MarkdownFhir] | [ReferenceFhir]
   *
   * The choice type for:
   * - `ArtifactAssessment.citeAs`
   * - `Evidence.citeAs`
   * - `EvidenceReport.citeAs`
   * - `ServiceRequest.patientInstruction.instruction`
   */
  public sealed interface MarkdownOrReference {
    public typealias Markdown = MarkdownFhir

    public typealias Reference = ReferenceFhir
  }

  /**
   * A FHIR choice type — one of: [MarkdownBox] | [StringBox] | [UrlFhir]
   *
   * The choice type for:
   * - `ImplementationGuide.definition.page.source`
   */
  public sealed interface MarkdownOrStringOrUrl {
    public typealias Markdown = MarkdownBox

    public typealias String = StringBox

    public typealias Url = UrlFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [DateFhir] | [IntegerFhir] | [MarkdownFhir] | [QuantityFhir]
   *
   * The choice type for:
   * - `MedicinalProductDefinition.characteristic.value`
   */
  public sealed interface MedicinalProductDefinitionCharacteristicValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Date = DateFhir

    public typealias Integer = IntegerFhir

    public typealias Markdown = MarkdownFhir

    public typealias Quantity = QuantityFhir
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
   * A FHIR choice type — one of: [AttachmentFhir] | [Base64BinaryFhir] | [BooleanFhir] |
   * [CodeableConceptFhir] | [QuantityFhir] | [StringFhir]
   *
   * The choice type for:
   * - `NutritionProduct.characteristic.value`
   */
  public sealed interface NutritionProductCharacteristicValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Base64Binary = Base64BinaryFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias Quantity = QuantityFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [AttachmentFhir] | [BooleanFhir] | [CodeableConceptFhir] |
   * [DateTimeFhir] | [IntegerFhir] | [PeriodFhir] | [QuantityFhir] | [RangeFhir] | [RatioFhir] |
   * [ReferenceFhir] | [SampledDataFhir] | [StringFhir] | [TimeFhir]
   *
   * The choice type for:
   * - `Observation.component.value`
   * - `Observation.value`
   */
  public sealed interface ObservationComponentValueChoice {
    public typealias Attachment = AttachmentFhir

    public typealias Boolean = BooleanFhir

    public typealias CodeableConcept = CodeableConceptFhir

    public typealias DateTime = DateTimeFhir

    public typealias Integer = IntegerFhir

    public typealias Period = PeriodFhir

    public typealias Quantity = QuantityFhir

    public typealias Range = RangeFhir

    public typealias Ratio = RatioFhir

    public typealias Reference = ReferenceFhir

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
   * A FHIR choice type — one of: [PeriodFhir] | [TimingFhir]
   *
   * The choice type for:
   * - `CareTeam.participant.coverage`
   */
  public sealed interface PeriodOrTiming {
    public typealias Period = PeriodFhir

    public typealias Timing = TimingFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RangeFhir]
   *
   * The choice type for:
   * - `Dosage.doseAndRate.dose`
   * - `EvidenceVariable.characteristic.duration`
   * - `EvidenceVariable.characteristic.instances`
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
   * A FHIR choice type — one of: [QuantityFhir] | [RangeFhir] | [StringFhir]
   *
   * The choice type for:
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
   * A FHIR choice type — one of: [QuantityFhir] | [RatioFhir] | [RatioRangeFhir]
   *
   * The choice type for:
   * - `Ingredient.substance.strength.referenceStrength.strength`
   */
  public sealed interface QuantityOrRatioOrRatioRange {
    public typealias Quantity = QuantityFhir

    public typealias Ratio = RatioFhir

    public typealias RatioRange = RatioRangeFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [RatioFhir] | [StringFhir]
   *
   * The choice type for:
   * - `SubstanceDefinition.relationship.amount`
   */
  public sealed interface QuantityOrRatioOrString {
    public typealias Quantity = QuantityFhir

    public typealias Ratio = RatioFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [QuantityFhir] | [StringFhir]
   *
   * The choice type for:
   * - `SpecimenDefinition.typeTested.container.minimumVolume`
   * - `SubstanceDefinition.moiety.amount`
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
   * A FHIR choice type — one of: [RangeFhir] | [StringFhir]
   *
   * The choice type for:
   * - `ClinicalUseDefinition.indication.duration`
   */
  public sealed interface RangeOrString {
    public typealias Range = RangeFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [ReferenceFhir] | [StringFhir]
   *
   * The choice type for:
   * - `Annotation.author`
   * - `TestPlan.testCase.testData.source`
   * - `TestPlan.testCase.testRun.script.source`
   */
  public sealed interface ReferenceOrString {
    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir
  }

  /**
   * A FHIR choice type — one of: [ReferenceFhir] | [StringFhir] | [UriFhir]
   *
   * The choice type for:
   * - `AuditEvent.agent.network`
   */
  public sealed interface ReferenceOrStringOrUri {
    public typealias Reference = ReferenceFhir

    public typealias String = StringFhir

    public typealias Uri = UriFhir
  }

  /**
   * A FHIR choice type — one of: [ReferenceFhir] | [UrlFhir]
   *
   * The choice type for:
   * - `MessageHeader.destination.endpoint`
   * - `MessageHeader.source.endpoint`
   */
  public sealed interface ReferenceOrUrl {
    public typealias Reference = ReferenceFhir

    public typealias Url = UrlFhir
  }

  /**
   * A FHIR choice type — one of: [StringFhir] | [UriFhir]
   *
   * The choice type for:
   * - `MedicationKnowledge.medicineClassification.source`
   */
  public sealed interface StringOrUri {
    public typealias String = StringFhir

    public typealias Uri = UriFhir
  }
}
