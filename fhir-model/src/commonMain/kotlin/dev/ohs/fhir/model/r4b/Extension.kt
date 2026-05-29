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

import dev.ohs.fhir.model.r4b.serializers.ExtensionSerializer
import kotlin.String
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Extension Type: Optional Extension Element - found in all resources.
 */
@Serializable(with = ExtensionSerializer::class)
public data class Extension(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
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
  public val url: String,
  /**
   * Value of extension - must be one of a constrained set of the data types (see
   * [Extensibility](extensibility.html) for a list).
   *
   * A FHIR choice type — one of: [Address] | [AgeBox] | [Annotation] | [Attachment] |
   * [Base64Binary] | [Boolean] | [CanonicalBox] | [CodeBox] | [CodeableConcept] |
   * [CodeableReference] | [Coding] | [ContactDetail] | [ContactPoint] | [Contributor] | [CountBox]
   * | [DataRequirement] | [Date] | [DateTime] | [Decimal] | [DistanceBox] | [Dosage] |
   * [DurationBox] | [Expression] | [HumanName] | [IdBox] | [Identifier] | [Instant] | [IntegerBox]
   * | [MarkdownBox] | [Money] | [OidBox] | [ParameterDefinition] | [Period] | [PositiveIntBox] |
   * [QuantityBox] | [Range] | [Ratio] | [RatioRange] | [Reference] | [RelatedArtifact] |
   * [SampledData] | [Signature] | [StringBox] | [Time] | [Timing] | [TriggerDefinition] |
   * [UnsignedIntBox] | [UriBox] | [UrlBox] | [UsageContext] | [UuidBox]
   */
  public val `value`: Extension.Value? = null,
) : Element() {
  public fun toBuilder(): Builder =
    with(this) {
      Builder(url).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        `value` = this@with.`value`
      }
    }

  public open class Builder(
    /**
     * Source of the definition for the extension code - a logical name or a URL.
     *
     * The definition may point directly to a computable or human-readable definition of the
     * extensibility codes, or it may be a logical URI as declared in some other specification. The
     * definition SHALL be a URI for the Structure Definition defining the extension.
     */
    public open var url: String
  ) {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and manageable, there is a strict set of
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
     * A FHIR choice type — one of: [Address] | [AgeBox] | [Annotation] | [Attachment] |
     * [Base64Binary] | [Boolean] | [CanonicalBox] | [CodeBox] | [CodeableConcept] |
     * [CodeableReference] | [Coding] | [ContactDetail] | [ContactPoint] | [Contributor] |
     * [CountBox] | [DataRequirement] | [Date] | [DateTime] | [Decimal] | [DistanceBox] | [Dosage] |
     * [DurationBox] | [Expression] | [HumanName] | [IdBox] | [Identifier] | [Instant] |
     * [IntegerBox] | [MarkdownBox] | [Money] | [OidBox] | [ParameterDefinition] | [Period] |
     * [PositiveIntBox] | [QuantityBox] | [Range] | [Ratio] | [RatioRange] | [Reference] |
     * [RelatedArtifact] | [SampledData] | [Signature] | [StringBox] | [Time] | [Timing] |
     * [TriggerDefinition] | [UnsignedIntBox] | [UriBox] | [UrlBox] | [UsageContext] | [UuidBox]
     */
    public open var `value`: Extension.Value? = null

    public open fun build(): Extension =
      Extension(id = id, extension = extension.map { it.build() }, url = url, `value` = `value`)
  }

  /**
   * A FHIR choice type — one of: [Address] | [AgeBox] | [Annotation] | [Attachment] |
   * [Base64Binary] | [Boolean] | [CanonicalBox] | [CodeBox] | [CodeableConcept] |
   * [CodeableReference] | [Coding] | [ContactDetail] | [ContactPoint] | [Contributor] | [CountBox]
   * | [DataRequirement] | [Date] | [DateTime] | [Decimal] | [DistanceBox] | [Dosage] |
   * [DurationBox] | [Expression] | [HumanName] | [IdBox] | [Identifier] | [Instant] | [IntegerBox]
   * | [MarkdownBox] | [Money] | [OidBox] | [ParameterDefinition] | [Period] | [PositiveIntBox] |
   * [QuantityBox] | [Range] | [Ratio] | [RatioRange] | [Reference] | [RelatedArtifact] |
   * [SampledData] | [Signature] | [StringBox] | [Time] | [Timing] | [TriggerDefinition] |
   * [UnsignedIntBox] | [UriBox] | [UrlBox] | [UsageContext] | [UuidBox]
   */
  public typealias Value = FhirChoiceTypes.ElementDefinitionDefaultValueChoice
}
