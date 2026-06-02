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

import dev.ohs.fhir.model.r4b.serializers.ParametersParameterSerializer
import dev.ohs.fhir.model.r4b.serializers.ParametersSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource is a non-persisted resource used to pass information into and back from an
 * [operation](operations.html). It has no other use, and there is no RESTful endpoint associated
 * with it.
 */
@Serializable(with = ParametersSerializer::class)
@SerialName("Parameters")
public data class Parameters(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
   */
  override val id: kotlin.String? = null,
  /**
   * The metadata about the resource. This is content that is maintained by the infrastructure.
   * Changes to the content might not always be associated with version changes to the resource.
   */
  override val meta: Meta? = null,
  /**
   * A reference to a set of rules that were followed when the resource was constructed, and which
   * must be understood when processing the content. Often, this is a reference to an implementation
   * guide that defines the special rules along with other profiles etc.
   *
   * Asserting this rule set restricts the content to be only understood by a limited set of trading
   * partners. This inherently limits the usefulness of the data in the long term. However, the
   * existing health eco-system is highly fractured, and not yet ready to define, collect, and
   * exchange data in a generally computable sense. Wherever possible, implementers and/or
   * specification writers should avoid using this element. Often, when used, the URL is a reference
   * to an implementation guide that defines these special rules as part of it's narrative along
   * with other profiles, value sets, etc.
   */
  override val implicitRules: Uri? = null,
  /**
   * The base language in which the resource is written.
   *
   * Language is provided to support indexing and accessibility (typically, services such as text to
   * speech use the language tag). The html language tag in the narrative applies to the narrative.
   * The language tag on the resource may be used to specify the language of other presentations
   * generated from the data in the resource. Not all the content has to be in the base language.
   * The Resource.language should not be assumed to apply to the narrative automatically. If a
   * language is specified, it should it also be specified on the div element in the html (see rules
   * in HTML5 for information about the relationship between xml:lang and the html lang attribute).
   */
  override val language: Code? = null,
  /** A parameter passed to or received from the operation. */
  public val parameter: List<Parameter> = listOf(),
) : Resource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A parameter passed to or received from the operation. */
  @Serializable(with = ParametersParameterSerializer::class)
  public data class Parameter(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** The name of the parameter (reference to the operation definition). */
    public val name: String,
    /**
     * Conveys the content if the parameter is a data type.
     *
     * A FHIR choice type — one of: [Address] | [Age] | [Annotation] | [Attachment] | [Base64Binary]
     * | [Boolean] | [Canonical] | [Code] | [CodeableConcept] | [Coding] | [ContactDetail] |
     * [ContactPoint] | [Contributor] | [Count] | [DataRequirement] | [Date] | [DateTime] |
     * [Decimal] | [Distance] | [Dosage] | [Duration] | [Expression] | [HumanName] | [Id] |
     * [Identifier] | [Instant] | [Integer] | [Markdown] | [Meta] | [Money] | [Oid] |
     * [ParameterDefinition] | [Period] | [PositiveInt] | [Quantity] | [Range] | [Ratio] |
     * [Reference] | [RelatedArtifact] | [SampledData] | [Signature] | [String] | [Time] | [Timing]
     * | [TriggerDefinition] | [UnsignedInt] | [Uri] | [Url] | [UsageContext] | [Uuid]
     */
    public val `value`: Value? = null,
    /**
     * If the parameter is a whole resource.
     *
     * When resolving references in resources, the operation definition may specify how references
     * may be resolved between parameters. If a reference cannot be resolved between the parameters,
     * the application should fall back to it's general resource resolution methods.
     */
    public val resource: Resource? = null,
    /**
     * A named part of a multi-part parameter.
     *
     * Only one level of nested parameters is allowed.
     */
    public val part: List<Parameter> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          `value` = this@with.`value`
          resource = this@with.resource?.toBuilder()
          part = this@with.part.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * A FHIR choice type — one of: [Address] | [Age] | [Annotation] | [Attachment] | [Base64Binary]
     * | [Boolean] | [Canonical] | [Code] | [CodeableConcept] | [Coding] | [ContactDetail] |
     * [ContactPoint] | [Contributor] | [Count] | [DataRequirement] | [Date] | [DateTime] |
     * [Decimal] | [Distance] | [Dosage] | [Duration] | [Expression] | [HumanName] | [Id] |
     * [Identifier] | [Instant] | [Integer] | [Markdown] | [Meta] | [Money] | [Oid] |
     * [ParameterDefinition] | [Period] | [PositiveInt] | [Quantity] | [Range] | [Ratio] |
     * [Reference] | [RelatedArtifact] | [SampledData] | [Signature] | [String] | [Time] | [Timing]
     * | [TriggerDefinition] | [UnsignedInt] | [Uri] | [Url] | [UsageContext] | [Uuid]
     */
    public sealed interface Value {
      public typealias Address = dev.ohs.fhir.model.r4b.Address

      public typealias Age = dev.ohs.fhir.model.r4b.Age

      public typealias Annotation = dev.ohs.fhir.model.r4b.Annotation

      public typealias Attachment = dev.ohs.fhir.model.r4b.Attachment

      public typealias Base64Binary = dev.ohs.fhir.model.r4b.Base64Binary

      public typealias Boolean = dev.ohs.fhir.model.r4b.Boolean

      public typealias Canonical = dev.ohs.fhir.model.r4b.Canonical

      public typealias Code = dev.ohs.fhir.model.r4b.Code

      public typealias CodeableConcept = dev.ohs.fhir.model.r4b.CodeableConcept

      public typealias Coding = dev.ohs.fhir.model.r4b.Coding

      public typealias ContactDetail = dev.ohs.fhir.model.r4b.ContactDetail

      public typealias ContactPoint = dev.ohs.fhir.model.r4b.ContactPoint

      public typealias Contributor = dev.ohs.fhir.model.r4b.Contributor

      public typealias Count = dev.ohs.fhir.model.r4b.Count

      public typealias DataRequirement = dev.ohs.fhir.model.r4b.DataRequirement

      public typealias Date = dev.ohs.fhir.model.r4b.Date

      public typealias DateTime = dev.ohs.fhir.model.r4b.DateTime

      public typealias Decimal = dev.ohs.fhir.model.r4b.Decimal

      public typealias Distance = dev.ohs.fhir.model.r4b.Distance

      public typealias Dosage = dev.ohs.fhir.model.r4b.Dosage

      public typealias Duration = dev.ohs.fhir.model.r4b.Duration

      public typealias Expression = dev.ohs.fhir.model.r4b.Expression

      public typealias HumanName = dev.ohs.fhir.model.r4b.HumanName

      public typealias Id = dev.ohs.fhir.model.r4b.Id

      public typealias Identifier = dev.ohs.fhir.model.r4b.Identifier

      public typealias Instant = dev.ohs.fhir.model.r4b.Instant

      public typealias Integer = dev.ohs.fhir.model.r4b.Integer

      public typealias Markdown = dev.ohs.fhir.model.r4b.Markdown

      public typealias Meta = dev.ohs.fhir.model.r4b.Meta

      public typealias Money = dev.ohs.fhir.model.r4b.Money

      public typealias Oid = dev.ohs.fhir.model.r4b.Oid

      public typealias ParameterDefinition = dev.ohs.fhir.model.r4b.ParameterDefinition

      public typealias Period = dev.ohs.fhir.model.r4b.Period

      public typealias PositiveInt = dev.ohs.fhir.model.r4b.PositiveInt

      public typealias Quantity = dev.ohs.fhir.model.r4b.Quantity

      public typealias Range = dev.ohs.fhir.model.r4b.Range

      public typealias Ratio = dev.ohs.fhir.model.r4b.Ratio

      public typealias Reference = dev.ohs.fhir.model.r4b.Reference

      public typealias RelatedArtifact = dev.ohs.fhir.model.r4b.RelatedArtifact

      public typealias SampledData = dev.ohs.fhir.model.r4b.SampledData

      public typealias Signature = dev.ohs.fhir.model.r4b.Signature

      public typealias String = dev.ohs.fhir.model.r4b.String

      public typealias Time = dev.ohs.fhir.model.r4b.Time

      public typealias Timing = dev.ohs.fhir.model.r4b.Timing

      public typealias TriggerDefinition = dev.ohs.fhir.model.r4b.TriggerDefinition

      public typealias UnsignedInt = dev.ohs.fhir.model.r4b.UnsignedInt

      public typealias Uri = dev.ohs.fhir.model.r4b.Uri

      public typealias Url = dev.ohs.fhir.model.r4b.Url

      public typealias UsageContext = dev.ohs.fhir.model.r4b.UsageContext

      public typealias Uuid = dev.ohs.fhir.model.r4b.Uuid
    }

    public class Builder(
      /** The name of the parameter (reference to the operation definition). */
      public var name: String.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * Conveys the content if the parameter is a data type.
       *
       * A FHIR choice type — one of: [Address] | [Age] | [Annotation] | [Attachment] |
       * [Base64Binary] | [Boolean] | [Canonical] | [Code] | [CodeableConcept] | [Coding] |
       * [ContactDetail] | [ContactPoint] | [Contributor] | [Count] | [DataRequirement] | [Date] |
       * [DateTime] | [Decimal] | [Distance] | [Dosage] | [Duration] | [Expression] | [HumanName] |
       * [Id] | [Identifier] | [Instant] | [Integer] | [Markdown] | [Meta] | [Money] | [Oid] |
       * [ParameterDefinition] | [Period] | [PositiveInt] | [Quantity] | [Range] | [Ratio] |
       * [Reference] | [RelatedArtifact] | [SampledData] | [Signature] | [String] | [Time] |
       * [Timing] | [TriggerDefinition] | [UnsignedInt] | [Uri] | [Url] | [UsageContext] | [Uuid]
       */
      public var `value`: Value? = null

      /**
       * If the parameter is a whole resource.
       *
       * When resolving references in resources, the operation definition may specify how references
       * may be resolved between parameters. If a reference cannot be resolved between the
       * parameters, the application should fall back to it's general resource resolution methods.
       */
      public var resource: Resource.Builder? = null

      /**
       * A named part of a multi-part parameter.
       *
       * Only one level of nested parameters is allowed.
       */
      public var part: MutableList<Builder> = mutableListOf()

      public fun build(): Parameter =
        Parameter(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          `value` = `value`,
          resource = resource?.build(),
          part = part.map { it.build() },
        )
    }
  }

  public class Builder() : Resource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    public var id: kotlin.String? = null

    /**
     * The metadata about the resource. This is content that is maintained by the infrastructure.
     * Changes to the content might not always be associated with version changes to the resource.
     */
    public var meta: Meta.Builder? = null

    /**
     * A reference to a set of rules that were followed when the resource was constructed, and which
     * must be understood when processing the content. Often, this is a reference to an
     * implementation guide that defines the special rules along with other profiles etc.
     *
     * Asserting this rule set restricts the content to be only understood by a limited set of
     * trading partners. This inherently limits the usefulness of the data in the long term.
     * However, the existing health eco-system is highly fractured, and not yet ready to define,
     * collect, and exchange data in a generally computable sense. Wherever possible, implementers
     * and/or specification writers should avoid using this element. Often, when used, the URL is a
     * reference to an implementation guide that defines these special rules as part of it's
     * narrative along with other profiles, value sets, etc.
     */
    public var implicitRules: Uri.Builder? = null

    /**
     * The base language in which the resource is written.
     *
     * Language is provided to support indexing and accessibility (typically, services such as text
     * to speech use the language tag). The html language tag in the narrative applies to the
     * narrative. The language tag on the resource may be used to specify the language of other
     * presentations generated from the data in the resource. Not all the content has to be in the
     * base language. The Resource.language should not be assumed to apply to the narrative
     * automatically. If a language is specified, it should it also be specified on the div element
     * in the html (see rules in HTML5 for information about the relationship between xml:lang and
     * the html lang attribute).
     */
    public var language: Code.Builder? = null

    /** A parameter passed to or received from the operation. */
    public var parameter: MutableList<Parameter.Builder> = mutableListOf()

    override fun build(): Parameters =
      Parameters(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        parameter = parameter.map { it.build() },
      )
  }
}
