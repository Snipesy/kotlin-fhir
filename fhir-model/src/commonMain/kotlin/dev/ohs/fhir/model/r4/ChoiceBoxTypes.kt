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

import kotlin.jvm.JvmInline

/**
 * A box type for the FHIR `Age` choice-type expansion — an inline wrapper around a [Age].
 *
 * It exists so `Age` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class AgeBox(public val `value`: Age) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Canonical` choice-type expansion — an inline wrapper around a
 * [Canonical].
 *
 * It exists so `Canonical` can be a distinct, non-overlapping member of the choice interfaces: a
 * box is emitted only where the bare model type would be indistinguishable from another member by
 * an `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class CanonicalBox(public val `value`: Canonical) :
  ConceptMap.Source,
  ConceptMap.Target,
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  GuidanceResponse.Module,
  Parameters.Parameter.Value,
  PlanDefinition.Action.Definition,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Code` choice-type expansion — an inline wrapper around a [Code].
 *
 * It exists so `Code` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class CodeBox(public val `value`: Code) :
  CodeSystem.Concept.Property.Value,
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value,
  ValueSet.Expansion.Parameter.Value

/**
 * A box type for the FHIR `Count` choice-type expansion — an inline wrapper around a [Count].
 *
 * It exists so `Count` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class CountBox(public val `value`: Count) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Distance` choice-type expansion — an inline wrapper around a [Distance].
 *
 * It exists so `Distance` can be a distinct, non-overlapping member of the choice interfaces: a box
 * is emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class DistanceBox(public val `value`: Distance) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Duration` choice-type expansion — an inline wrapper around a [Duration].
 *
 * It exists so `Duration` can be a distinct, non-overlapping member of the choice interfaces: a box
 * is emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class DurationBox(public val `value`: Duration) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Id` choice-type expansion — an inline wrapper around a [Id].
 *
 * It exists so `Id` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class IdBox(public val `value`: Id) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  StructureMap.Group.Rule.Target.Parameter.Value,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Integer` choice-type expansion — an inline wrapper around a [Integer].
 *
 * It exists so `Integer` can be a distinct, non-overlapping member of the choice interfaces: a box
 * is emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class IntegerBox(public val `value`: Integer) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.MaxValue,
  ElementDefinition.MinValue,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Markdown` choice-type expansion — an inline wrapper around a [Markdown].
 *
 * It exists so `Markdown` can be a distinct, non-overlapping member of the choice interfaces: a box
 * is emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class MarkdownBox(public val `value`: Markdown) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Oid` choice-type expansion — an inline wrapper around a [Oid].
 *
 * It exists so `Oid` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class OidBox(public val `value`: Oid) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `PositiveInt` choice-type expansion — an inline wrapper around a
 * [PositiveInt].
 *
 * It exists so `PositiveInt` can be a distinct, non-overlapping member of the choice interfaces: a
 * box is emitted only where the bare model type would be indistinguishable from another member by
 * an `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class PositiveIntBox(public val `value`: PositiveInt) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.MaxValue,
  ElementDefinition.MinValue,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Quantity` choice-type expansion — an inline wrapper around a [Quantity].
 *
 * It exists so `Quantity` can be a distinct, non-overlapping member of the choice interfaces: a box
 * is emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class QuantityBox(public val `value`: Quantity) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `String` choice-type expansion — an inline wrapper around a [String].
 *
 * It exists so `String` can be a distinct, non-overlapping member of the choice interfaces: a box
 * is emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class StringBox(public val `value`: String) :
  CodeSystem.Concept.Property.Value,
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  StructureMap.Group.Rule.Target.Parameter.Value,
  Task.Input.Value,
  Task.Output.Value,
  ValueSet.Expansion.Parameter.Value

/**
 * A box type for the FHIR `UnsignedInt` choice-type expansion — an inline wrapper around a
 * [UnsignedInt].
 *
 * It exists so `UnsignedInt` can be a distinct, non-overlapping member of the choice interfaces: a
 * box is emitted only where the bare model type would be indistinguishable from another member by
 * an `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class UnsignedIntBox(public val `value`: UnsignedInt) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.MaxValue,
  ElementDefinition.MinValue,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Uri` choice-type expansion — an inline wrapper around a [Uri].
 *
 * It exists so `Uri` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class UriBox(public val `value`: Uri) :
  ConceptMap.Source,
  ConceptMap.Target,
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  GuidanceResponse.Module,
  Parameters.Parameter.Value,
  PlanDefinition.Action.Definition,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Url` choice-type expansion — an inline wrapper around a [Url].
 *
 * It exists so `Url` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class UrlBox(public val `value`: Url) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value

/**
 * A box type for the FHIR `Uuid` choice-type expansion — an inline wrapper around a [Uuid].
 *
 * It exists so `Uuid` can be a distinct, non-overlapping member of the choice interfaces: a box is
 * emitted only where the bare model type would be indistinguishable from another member by an
 * `is`-check (a FHIR ancestor/descendant such as `Quantity`/`Age`, or a type the model can't
 * implement directly). Most choice members are bare and need no box.
 */
@JvmInline
public value class UuidBox(public val `value`: Uuid) :
  ElementDefinition.DefaultValue,
  ElementDefinition.Example.Value,
  ElementDefinition.Fixed,
  ElementDefinition.Pattern,
  Extension.Value,
  Parameters.Parameter.Value,
  StructureMap.Group.Rule.Source.DefaultValue,
  Task.Input.Value,
  Task.Output.Value
