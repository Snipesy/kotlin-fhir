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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r5.FhirDecimal as R5FhirDecimal
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class FhirDecimalTest {
  // --- Lexical round-trip: fromString preserves the exact wire form verbatim. ---
  @Test fun plainInteger_roundTrips() = roundTrip("100")

  @Test fun zero_roundTrips() = roundTrip("0")

  @Test fun negative_roundTrips() = roundTrip("-3.14")

  @Test fun trailingZeros_arePreserved() = roundTrip("1.00")

  @Test fun singleTrailingZero_isPreserved() = roundTrip("1.0")

  @Test fun leadingFractionZeros_arePreserved() = roundTrip("0.0100")

  @Test fun lowercaseScientific_roundTrips() = roundTrip("1.5e-3")

  @Test fun uppercaseScientific_roundTrips() = roundTrip("1E-22")

  @Test fun largeNegativeScientific_roundTrips() = roundTrip("-1.000000000000000000E+245")

  private fun roundTrip(value: String) {
    val decimal = FhirDecimal.fromString(value)
    assertEquals(value, decimal.wire)
    assertEquals(value, decimal.toString())
  }

  // --- Regex violations are rejected at construction with IllegalArgumentException. ---
  @Test fun rejectsNonNumeric() = rejected("abc")

  @Test fun rejectsEmptyString() = rejected("")

  @Test fun rejectsLeadingPlus() = rejected("+1")

  @Test fun rejectsTwoDecimalPoints() = rejected("1.2.3")

  @Test fun rejectsCommaSeparator() = rejected("1,5")

  @Test fun rejectsTrailingDot() = rejected("1.")

  @Test fun rejectsLeadingZeroInteger() = rejected("01")

  @Test fun rejectsLeadingWhitespace() = rejected(" 1")

  @Test fun rejectsHexNotation() = rejected("0x10")

  private fun rejected(value: String) {
    assertFailsWith<IllegalArgumentException> { FhirDecimal.fromString(value) }
  }

  // --- fromBigDecimal derives a canonical, regex-valid wire form. ---
  @Test
  fun fromBigDecimal_derivesRegexValidWire() {
    val decimal = FhirDecimal.fromBigDecimal(BigDecimal.fromInt(100))
    assertTrue(decimal.wire.matches(FhirDecimal.WIRE_REGEX))
    assertEquals(0, decimal.compareTo(FhirDecimal.fromString("100")))
  }

  @Test
  fun asBigDecimal_returnsTheUnderlyingValue() {
    val bigDecimal = BigDecimal.parseString("12.5")
    val decimal = FhirDecimal.fromBigDecimal(bigDecimal)
    assertEquals(0, decimal.asBigDecimal().compareTo(bigDecimal))
  }

  // --- Arithmetic re-derives a valid wire and stays numerically correct. ---
  @Test
  fun addition_isNumericallyCorrectAndRegexValid() {
    val sum = FhirDecimal.fromString("1.5") + FhirDecimal.fromString("2.5")
    assertTrue(sum.wire.matches(FhirDecimal.WIRE_REGEX))
    assertEquals(0, sum.compareTo(FhirDecimal.fromString("4")))
  }

  // --- The bound is version-specific: R5/R6 cap digit counts; R4 does not. ---
  @Test
  fun r5_rejectsNineteenDigitInteger() {
    // 19 integer digits exceeds R5's `[1-9][0-9]{0,17}` (max 18).
    assertFailsWith<IllegalArgumentException> { R5FhirDecimal.fromString("1234567890123456789") }
  }

  @Test
  fun r4_acceptsNineteenDigitInteger() {
    // R4's regex is unbounded.
    assertEquals("1234567890123456789", FhirDecimal.fromString("1234567890123456789").wire)
  }

  @Test
  fun r5_acceptsScientificNotation() {
    // Guards against the upstream HL7 regex typo (`{1,9}}`) that would reject exponents.
    assertEquals("1E-22", R5FhirDecimal.fromString("1E-22").wire)
  }
}
