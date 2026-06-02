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

import dev.ohs.fhir.model.r5.serializers.ExtensionSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/** Extension Type: Optional Extension Element - found in all resources. */
@Serializable(with = ExtensionSerializer::class)
public data class Extension(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and managable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any implementer can define an
   * extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * Source of the definition for the extension code - a logical name or a URL.
   *
   * The definition may point directly to a computable or human-readable definition of the
   * extensibility codes, or it may be a logical URI as declared in some other specification. The
   * definition SHALL be a URI for the Structure Definition defining the extension.
   */
  public val url: kotlin.String,
  /**
   * Value of extension - must be one of a constrained set of the data types (see
   * [Extensibility](extensibility.html) for a list).
   *
   * A FHIR choice type — one of: [Address] | [Age] | [Annotation] | [Attachment] | [Availability] |
   * [Base64Binary] | [Boolean] | [Canonical] | [Code] | [CodeableConcept] | [CodeableReference] |
   * [Coding] | [ContactDetail] | [ContactPoint] | [Count] | [DataRequirement] | [Date] | [DateTime]
   * | [Decimal] | [Distance] | [Dosage] | [Duration] | [Expression] | [ExtendedContactDetail] |
   * [HumanName] | [Id] | [Identifier] | [Instant] | [Integer] | [Integer64] | [Markdown] | [Meta] |
   * [Money] | [Oid] | [ParameterDefinition] | [Period] | [PositiveInt] | [Quantity] | [Range] |
   * [Ratio] | [RatioRange] | [Reference] | [RelatedArtifact] | [SampledData] | [Signature] |
   * [String] | [Time] | [Timing] | [TriggerDefinition] | [UnsignedInt] | [Uri] | [Url] |
   * [UsageContext] | [Uuid]
   */
  public val `value`: Value? = null,
) : DataType() {
  public fun toBuilder(): Builder =
    with(this) {
      Builder(url).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        `value` = this@with.`value`
      }
    }

  /**
   * A FHIR choice type — one of: [Address] | [Age] | [Annotation] | [Attachment] | [Availability] |
   * [Base64Binary] | [Boolean] | [Canonical] | [Code] | [CodeableConcept] | [CodeableReference] |
   * [Coding] | [ContactDetail] | [ContactPoint] | [Count] | [DataRequirement] | [Date] | [DateTime]
   * | [Decimal] | [Distance] | [Dosage] | [Duration] | [Expression] | [ExtendedContactDetail] |
   * [HumanName] | [Id] | [Identifier] | [Instant] | [Integer] | [Integer64] | [Markdown] | [Meta] |
   * [Money] | [Oid] | [ParameterDefinition] | [Period] | [PositiveInt] | [Quantity] | [Range] |
   * [Ratio] | [RatioRange] | [Reference] | [RelatedArtifact] | [SampledData] | [Signature] |
   * [String] | [Time] | [Timing] | [TriggerDefinition] | [UnsignedInt] | [Uri] | [Url] |
   * [UsageContext] | [Uuid]
   */
  public sealed interface Value {
    public typealias Address = dev.ohs.fhir.model.r5.Address

    public typealias Age = dev.ohs.fhir.model.r5.Age

    public typealias Annotation = dev.ohs.fhir.model.r5.Annotation

    public typealias Attachment = dev.ohs.fhir.model.r5.Attachment

    public typealias Availability = dev.ohs.fhir.model.r5.Availability

    public typealias Base64Binary = dev.ohs.fhir.model.r5.Base64Binary

    public typealias Boolean = dev.ohs.fhir.model.r5.Boolean

    public typealias Canonical = dev.ohs.fhir.model.r5.Canonical

    public typealias Code = dev.ohs.fhir.model.r5.Code

    public typealias CodeableConcept = dev.ohs.fhir.model.r5.CodeableConcept

    public typealias CodeableReference = dev.ohs.fhir.model.r5.CodeableReference

    public typealias Coding = dev.ohs.fhir.model.r5.Coding

    public typealias ContactDetail = dev.ohs.fhir.model.r5.ContactDetail

    public typealias ContactPoint = dev.ohs.fhir.model.r5.ContactPoint

    public typealias Count = dev.ohs.fhir.model.r5.Count

    public typealias DataRequirement = dev.ohs.fhir.model.r5.DataRequirement

    public typealias Date = dev.ohs.fhir.model.r5.Date

    public typealias DateTime = dev.ohs.fhir.model.r5.DateTime

    public typealias Decimal = dev.ohs.fhir.model.r5.Decimal

    public typealias Distance = dev.ohs.fhir.model.r5.Distance

    public typealias Dosage = dev.ohs.fhir.model.r5.Dosage

    public typealias Duration = dev.ohs.fhir.model.r5.Duration

    public typealias Expression = dev.ohs.fhir.model.r5.Expression

    public typealias ExtendedContactDetail = dev.ohs.fhir.model.r5.ExtendedContactDetail

    public typealias HumanName = dev.ohs.fhir.model.r5.HumanName

    public typealias Id = dev.ohs.fhir.model.r5.Id

    public typealias Identifier = dev.ohs.fhir.model.r5.Identifier

    public typealias Instant = dev.ohs.fhir.model.r5.Instant

    public typealias Integer = dev.ohs.fhir.model.r5.Integer

    public typealias Integer64 = dev.ohs.fhir.model.r5.Integer64

    public typealias Markdown = dev.ohs.fhir.model.r5.Markdown

    public typealias Meta = dev.ohs.fhir.model.r5.Meta

    public typealias Money = dev.ohs.fhir.model.r5.Money

    public typealias Oid = dev.ohs.fhir.model.r5.Oid

    public typealias ParameterDefinition = dev.ohs.fhir.model.r5.ParameterDefinition

    public typealias Period = dev.ohs.fhir.model.r5.Period

    public typealias PositiveInt = dev.ohs.fhir.model.r5.PositiveInt

    public typealias Quantity = dev.ohs.fhir.model.r5.Quantity

    public typealias Range = dev.ohs.fhir.model.r5.Range

    public typealias Ratio = dev.ohs.fhir.model.r5.Ratio

    public typealias RatioRange = dev.ohs.fhir.model.r5.RatioRange

    public typealias Reference = dev.ohs.fhir.model.r5.Reference

    public typealias RelatedArtifact = dev.ohs.fhir.model.r5.RelatedArtifact

    public typealias SampledData = dev.ohs.fhir.model.r5.SampledData

    public typealias Signature = dev.ohs.fhir.model.r5.Signature

    public typealias String = dev.ohs.fhir.model.r5.String

    public typealias Time = dev.ohs.fhir.model.r5.Time

    public typealias Timing = dev.ohs.fhir.model.r5.Timing

    public typealias TriggerDefinition = dev.ohs.fhir.model.r5.TriggerDefinition

    public typealias UnsignedInt = dev.ohs.fhir.model.r5.UnsignedInt

    public typealias Uri = dev.ohs.fhir.model.r5.Uri

    public typealias Url = dev.ohs.fhir.model.r5.Url

    public typealias UsageContext = dev.ohs.fhir.model.r5.UsageContext

    public typealias Uuid = dev.ohs.fhir.model.r5.Uuid
  }

  public open class Builder(
    /**
     * Source of the definition for the extension code - a logical name or a URL.
     *
     * The definition may point directly to a computable or human-readable definition of the
     * extensibility codes, or it may be a logical URI as declared in some other specification. The
     * definition SHALL be a URI for the Structure Definition defining the extension.
     */
    public open var url: kotlin.String
  ) {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: kotlin.String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and managable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public open var extension: MutableList<Builder> = mutableListOf()

    /**
     * Value of extension - must be one of a constrained set of the data types (see
     * [Extensibility](extensibility.html) for a list).
     *
     * A FHIR choice type — one of: [Address] | [Age] | [Annotation] | [Attachment] | [Availability]
     * | [Base64Binary] | [Boolean] | [Canonical] | [Code] | [CodeableConcept] | [CodeableReference]
     * | [Coding] | [ContactDetail] | [ContactPoint] | [Count] | [DataRequirement] | [Date] |
     * [DateTime] | [Decimal] | [Distance] | [Dosage] | [Duration] | [Expression] |
     * [ExtendedContactDetail] | [HumanName] | [Id] | [Identifier] | [Instant] | [Integer] |
     * [Integer64] | [Markdown] | [Meta] | [Money] | [Oid] | [ParameterDefinition] | [Period] |
     * [PositiveInt] | [Quantity] | [Range] | [Ratio] | [RatioRange] | [Reference] |
     * [RelatedArtifact] | [SampledData] | [Signature] | [String] | [Time] | [Timing] |
     * [TriggerDefinition] | [UnsignedInt] | [Uri] | [Url] | [UsageContext] | [Uuid]
     */
    public open var `value`: Value? = null

    public open fun build(): Extension =
      Extension(id = id, extension = extension.map { it.build() }, url = url, `value` = `value`)
  }
}
