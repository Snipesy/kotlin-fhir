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

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.Resource as R5Resource
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.serializer

/**
 * `decimal` values arrive as untrusted JSON. The serializer must accept exactly the FHIR decimal
 * grammar as an unquoted number literal, reject everything else with a [SerializationException],
 * and do so in bounded time regardless of the literal's size.
 */
class FhirDecimalJsonInputTest :
  FunSpec({
    fun observation(value: String) =
      """{"resourceType":"Observation","status":"final","code":{},"valueQuantity":{"value":$value}}"""

    fun <T : Any> suite(fhirVersion: String, resourceSerializer: KSerializer<T>) {
      fun decode(value: String): T =
        testJson.decodeFromString(resourceSerializer, observation(value))

      fun encodedValue(resource: T): String =
        testJson
          .encodeToString(resourceSerializer, resource)
          .substringAfter("\"value\": ")
          .substringBefore("\n")
          .trimEnd(',')

      fun rejects(value: String) {
        assertFailsWith<SerializationException>("expected '${value.take(32)}' to be rejected") {
          decode(value)
        }
      }

      context("$fhirVersion decimal JSON input") {
        test("number literal round-trips verbatim") {
          assertEquals("1.50", encodedValue(decode("1.50")))
          assertEquals(
            "-1.000000000000000000E+245",
            encodedValue(decode("-1.000000000000000000E+245")),
          )
        }
        test("quoted number is rejected") { rejects("\"1.5\"") }
        test("boolean is rejected") { rejects("true") }
        test("object is rejected") { rejects("{}") }
        test("array is rejected") { rejects("[1]") }
        test("literals outside the FHIR grammar are rejected") {
          rejects("+1")
          rejects(".5")
          rejects("5.")
          rejects("00012")
          rejects("1e5e5")
          rejects("1e")
          rejects("NaN")
        }
        test("oversized digit string is rejected") { rejects("1".repeat(20_000)) }
        test("oversized exponent is rejected") {
          rejects("1e999999999")
          rejects("1e10000")
        }
        test("decoded extremes are comparable") {
          val big = decode("1e9999")
          val one = decode("1")
          assertTrue(big != one)
        }
      }
    }

    suite("R4", serializer<R4Resource>())
    suite("R4B", serializer<R4bResource>())
    suite("R5", serializer<R5Resource>())
  })
