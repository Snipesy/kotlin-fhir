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

import dev.ohs.fhir.model.r4.serializers.UsageContextSerializer
import kotlin.String
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for UsageContext Type: Specifies clinical/business/etc. metadata that
 * can be used to retrieve, index and/or categorize an artifact. This metadata can either be
 * specific to the applicable population (e.g., age category, DRG) or the specific context of care
 * (e.g., venue, care setting, provider of care).
 */
@Serializable(with = UsageContextSerializer::class)
public data class UsageContext(
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
  /** A code that identifies the type of context being specified by this usage context. */
  public val code: Coding,
  /**
   * A value that defines the context specified in this context of use. The interpretation of the
   * value is defined by the code.
   *
   * A FHIR choice type — one of: [CodeableConcept] | [Quantity] | [Range] | [Reference]
   */
  public val `value`: UsageContext.Value,
) : Element(), FhirChoiceTypes.ElementDefinitionDefaultValueChoice {
  public fun toBuilder(): Builder =
    with(this) {
      Builder(code.toBuilder(), `value`).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
      }
    }

  public open class Builder(
    /** A code that identifies the type of context being specified by this usage context. */
    public open var code: Coding.Builder,
    /**
     * A value that defines the context specified in this context of use. The interpretation of the
     * value is defined by the code.
     *
     * A FHIR choice type — one of: [CodeableConcept] | [Quantity] | [Range] | [Reference]
     */
    public open var `value`: UsageContext.Value,
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
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

    public open fun build(): UsageContext =
      UsageContext(
        id = id,
        extension = extension.map { it.build() },
        code = code.build(),
        `value` = `value`,
      )
  }

  /** A FHIR choice type — one of: [CodeableConcept] | [Quantity] | [Range] | [Reference] */
  public typealias Value = FhirChoiceTypes.CodeableConceptOrQuantityOrRangeOrReference
}
