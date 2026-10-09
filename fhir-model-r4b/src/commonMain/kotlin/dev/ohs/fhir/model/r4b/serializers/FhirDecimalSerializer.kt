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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.FhirDecimal
import kotlin.IllegalArgumentException
import kotlin.OptIn
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonUnquotedLiteral

/** Serializer for `FhirDecimal` which outputs unquoted JSON literals. */
internal object FhirDecimalSerializer : KSerializer<FhirDecimal> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("FhirDecimal", PrimitiveKind.STRING)

  @JvmField
  internal val nullableListSerializer: KSerializer<List<FhirDecimal?>> =
    ListSerializer(this.nullable)

  @OptIn(ExperimentalSerializationApi::class)
  override fun serialize(encoder: Encoder, `value`: FhirDecimal) {
    if (encoder is JsonEncoder) {
      encoder.encodeSerializableValue(JsonPrimitive.serializer(), JsonUnquotedLiteral(value.wire))
    } else {
      encoder.encodeString(value.wire)
    }
  }

  /**
   * Decodes a FHIR `decimal`. JSON input must be an unquoted number literal; anything else (a
   * quoted string, object, array, or a literal outside the FHIR decimal grammar and the
   * `FhirDecimal.fromString` limits) fails with a [SerializationException].
   */
  override fun deserialize(decoder: Decoder): FhirDecimal {
    val string =
      if (decoder is JsonDecoder) {
        val element = decoder.decodeJsonElement()
        if (element !is JsonPrimitive || element.isString) {
          throw SerializationException("Expected a JSON number for decimal")
        }
        element.content
      } else {
        decoder.decodeString()
      }
    return try {
      FhirDecimal.fromString(string)
    } catch (e: IllegalArgumentException) {
      throw SerializationException(e.message, e)
    }
  }
}
