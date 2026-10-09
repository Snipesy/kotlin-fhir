/*
 * Copyright 2025-2026 Open Health Stack Foundation
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

package dev.ohs.fhir.codegen.primitives

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName

/**
 * Generates a [FileSpec] for `FhirDecimal.kt`, the model representation of FHIR's `decimal`
 * primitive.
 *
 * `FhirDecimal` wraps an ionspin `BigDecimal` (kept `internal` so the bignum type never leaks into
 * this library's public API) and carries [wire] — the exact lexical form to emit on the wire:
 * - Values parsed from the wire keep their original lexical form verbatim (so `0.0100`, `1.5e-3`
 *   and trailing zeros round-trip byte-for-byte).
 * - Values constructed from a number use the `BigDecimal` plain-string form as their wire form.
 *
 * It implements the public `BigNumber<FhirDecimal>` interface (and `Comparable`) so it can be used
 * directly in arbitrary-precision arithmetic; results of arithmetic re-derive their canonical wire
 * form. The operator overloads (`+`, `-`, …) and narrowing conversions live on the bignum-internal
 * `CommonBigNumberOperations` / `NarrowingOperations` interfaces which cannot be implemented from
 * outside the bignum module, so the operators are declared directly here instead.
 */
object FhirDecimalFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val fd = ClassName(packageName, "FhirDecimal")
    val bigDecimal = ClassName("com.ionspin.kotlin.bignum.decimal", "BigDecimal")
    val bigInteger = ClassName("com.ionspin.kotlin.bignum.integer", "BigInteger")
    val bigNumber = ClassName("com.ionspin.kotlin.bignum", "BigNumber")
    val creator = bigNumber.nestedClass("Creator").parameterizedBy(fd)
    val string = String::class.asClassName()
    val boolean = Boolean::class.asClassName()
    val int = Int::class.asClassName()
    val long = Long::class.asClassName()
    val regex = Regex::class.asClassName()
    // Implementation limits exposed as companion constants and enforced after the regex match.
    val maxLength = 80
    val maxExponentDigits = 4

    // override fun <name>(other: FhirDecimal): FhirDecimal =
    // fromBigDecimal(bigDecimal.<delegate>(other.bigDecimal))
    fun binaryOp(name: String, delegate: String = name): FunSpec =
      FunSpec.builder(name)
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("other", fd)
        .returns(fd)
        .addStatement("return fromBigDecimal(bigDecimal.%L(other.bigDecimal))", delegate)
        .build()

    // override operator fun <name>(other: FhirDecimal): FhirDecimal = <op>(other)
    fun operatorOp(name: String, delegate: String): FunSpec =
      FunSpec.builder(name)
        .addModifiers(KModifier.PUBLIC, KModifier.OPERATOR)
        .addParameter("other", fd)
        .returns(fd)
        .addStatement("return %L(other)", delegate)
        .build()

    // override fun <name>(<param>: <type>): FhirDecimal =
    // fromBigDecimal(BigDecimal.<name>(<param>))
    fun factory(name: String, paramName: String, paramType: TypeName): FunSpec =
      FunSpec.builder(name)
        .addModifiers(KModifier.OVERRIDE)
        .addParameter(paramName, paramType)
        .returns(fd)
        .addStatement("return fromBigDecimal(%T.%L(%N))", bigDecimal, name, paramName)
        .build()

    val companion =
      TypeSpec.companionObjectBuilder()
        .addSuperinterface(creator)
        .addFunction(
          FunSpec.builder("fromString")
            .addKdoc(
              "Parses a wire/lexical decimal, preserving its exact lexical form for round-tripping.\n" +
                "\n" +
                "[string] must match the FHIR `decimal` grammar" +
                " (`-?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][+-]?[0-9]+)?`) and stay within the" +
                " implementation limits [MAX_LENGTH] characters and [MAX_EXPONENT_DIGITS] exponent" +
                " digits, which keep parsing, comparison and arithmetic cheap for any accepted value.\n" +
                "\n" +
                "@throws IllegalArgumentException if [string] is not an accepted decimal."
            )
            .addParameter("string", string)
            .returns(fd)
            .addStatement(
              "require(string.length <= MAX_LENGTH && LEXICAL_FORM.matches(string)) { %P }",
              "Invalid decimal value: '\${string.take(32)}'",
            )
            .addStatement(
              "require(exponentDigits(string) <= MAX_EXPONENT_DIGITS) { %P }",
              "Decimal exponent exceeds \$MAX_EXPONENT_DIGITS digits: '\${string.take(32)}'",
            )
            .addStatement("return FhirDecimal(%T.parseString(string), string)", bigDecimal)
            .build()
        )
        .addFunction(
          FunSpec.builder("exponentDigits")
            .addModifiers(KModifier.PRIVATE)
            .addKdoc("Digit count of the exponent part of a [string] that matches [LEXICAL_FORM].")
            .addParameter("string", string)
            .returns(int)
            .addCode(
              """
              |val marker = string.indexOfAny(charArrayOf('e', 'E'))
              |if (marker < 0) return 0
              |val sign = if (string[marker + 1] == '+' || string[marker + 1] == '-') 1 else 0
              |return string.length - marker - 1 - sign
              |"""
                .trimMargin()
            )
            .build()
        )
        .addProperty(
          PropertySpec.builder("MAX_LENGTH", int, KModifier.CONST)
            .addKdoc(
              "Maximum accepted length of a lexical decimal (the spec's own examples top out at 26)."
            )
            .initializer("%L", maxLength)
            .build()
        )
        .addProperty(
          PropertySpec.builder("MAX_EXPONENT_DIGITS", int, KModifier.CONST)
            .addKdoc("Maximum accepted exponent digits (the spec's own examples top out at 3).")
            .initializer("%L", maxExponentDigits)
            .build()
        )
        .addProperty(
          PropertySpec.builder("LEXICAL_FORM", regex, KModifier.PRIVATE)
            .addKdoc(
              "The FHIR `decimal` regex, verbatim from the R4 `StructureDefinition-decimal`" +
                " (R5 adds digit limits that reject valid R4 data, so the R4 form is used for all" +
                " versions)."
            )
            .initializer("%T(%S)", regex, "-?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][+-]?[0-9]+)?")
            .build()
        )
        .addFunction(
          FunSpec.builder("fromBigDecimal")
            .addKdoc(
              "Wraps a [BigDecimal], using its plain-string form as the wire representation."
            )
            .addParameter("bigDecimal", bigDecimal)
            .returns(fd)
            .addStatement("return FhirDecimal(bigDecimal, bigDecimal.toPlainString())")
            .build()
        )
        .addProperty(
          PropertySpec.builder("ZERO", fd)
            .addModifiers(KModifier.OVERRIDE)
            .initializer("fromBigDecimal(%T.ZERO)", bigDecimal)
            .build()
        )
        .addProperty(
          PropertySpec.builder("ONE", fd)
            .addModifiers(KModifier.OVERRIDE)
            .initializer("fromBigDecimal(%T.ONE)", bigDecimal)
            .build()
        )
        .addProperty(
          PropertySpec.builder("TWO", fd)
            .addModifiers(KModifier.OVERRIDE)
            .initializer("fromBigDecimal(%T.TWO)", bigDecimal)
            .build()
        )
        .addProperty(
          PropertySpec.builder("TEN", fd)
            .addModifiers(KModifier.OVERRIDE)
            .initializer("fromBigDecimal(%T.TEN)", bigDecimal)
            .build()
        )
        .addFunction(
          FunSpec.builder("parseString")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("string", string)
            .addParameter("base", int)
            .returns(fd)
            .addStatement(
              "return if (base == 10) fromString(string) else " +
                "fromBigDecimal(%T.parseString(string, base))",
              bigDecimal,
            )
            .build()
        )
        .addFunction(factory("fromULong", "uLong", ULong::class.asClassName()))
        .addFunction(factory("fromUInt", "uInt", UInt::class.asClassName()))
        .addFunction(factory("fromUShort", "uShort", UShort::class.asClassName()))
        .addFunction(factory("fromUByte", "uByte", UByte::class.asClassName()))
        .addFunction(factory("fromLong", "long", long))
        .addFunction(factory("fromInt", "int", int))
        .addFunction(factory("fromShort", "short", Short::class.asClassName()))
        .addFunction(factory("fromByte", "byte", Byte::class.asClassName()))
        .addFunction(factory("fromBigInteger", "bigInteger", bigInteger))
        .addFunction(
          FunSpec.builder("tryFromFloat")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("float", Float::class.asClassName())
            .addParameter("exactRequired", boolean)
            .returns(fd)
            .addStatement(
              "return fromBigDecimal(%T.tryFromFloat(float, exactRequired))",
              bigDecimal,
            )
            .build()
        )
        .addFunction(
          FunSpec.builder("tryFromDouble")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("double", Double::class.asClassName())
            .addParameter("exactRequired", boolean)
            .returns(fd)
            .addStatement(
              "return fromBigDecimal(%T.tryFromDouble(double, exactRequired))",
              bigDecimal,
            )
            .build()
        )
        .build()

    val typeSpec =
      TypeSpec.classBuilder(fd)
        .addKdoc(
          "FHIR `decimal` value: a precision-preserving rational number backed by an ionspin " +
            "`BigDecimal`. The wrapped value is kept `internal`; consumers operate on this type " +
            "through its `BigNumber` arithmetic surface and call [toString] for the exact lexical form."
        )
        .addSuperinterface(bigNumber.parameterizedBy(fd))
        // Comparable<Any> (not Comparable<FhirDecimal>) mirrors ionspin's own BigDecimal: a single
        // `compareTo(Any)` satisfies both BigNumber.compareTo(Any) and Comparable, avoiding the JVM
        // bridge-method clash two differently-typed `compareTo`s would cause.
        .addSuperinterface(
          ClassName("kotlin", "Comparable").parameterizedBy(Any::class.asClassName())
        )
        .primaryConstructor(
          FunSpec.constructorBuilder()
            .addModifiers(KModifier.PRIVATE)
            .addParameter("bigDecimal", bigDecimal)
            .addParameter("wire", string)
            .build()
        )
        .addProperty(
          PropertySpec.builder("bigDecimal", bigDecimal)
            .addModifiers(KModifier.INTERNAL)
            .initializer("bigDecimal")
            .build()
        )
        .addProperty(
          PropertySpec.builder("wire", string)
            .addModifiers(KModifier.INTERNAL)
            .addKdoc("The exact lexical form to emit on the wire.")
            .initializer("wire")
            .build()
        )
        .addType(companion)
        // BigNumber<FhirDecimal> surface, delegated to the wrapped BigDecimal.
        .addFunction(
          FunSpec.builder("getCreator")
            .addModifiers(KModifier.OVERRIDE)
            .returns(creator)
            .addStatement("return FhirDecimal")
            .build()
        )
        .addFunction(binaryOp("add"))
        .addFunction(binaryOp("subtract"))
        .addFunction(binaryOp("multiply"))
        .addFunction(binaryOp("divide"))
        .addFunction(binaryOp("remainder"))
        .addFunction(
          FunSpec.builder("divideAndRemainder")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("other", fd)
            .returns(ClassName("kotlin", "Pair").parameterizedBy(fd, fd))
            .addStatement("val (quotient, rem) = bigDecimal.divideAndRemainder(other.bigDecimal)")
            .addStatement("return fromBigDecimal(quotient) to fromBigDecimal(rem)")
            .build()
        )
        .addFunction(
          FunSpec.builder("isZero")
            .addModifiers(KModifier.OVERRIDE)
            .returns(boolean)
            .addStatement("return bigDecimal.isZero()")
            .build()
        )
        .addFunction(
          FunSpec.builder("negate")
            .addModifiers(KModifier.OVERRIDE)
            .returns(fd)
            .addStatement("return fromBigDecimal(bigDecimal.negate())")
            .build()
        )
        .addFunction(
          FunSpec.builder("abs")
            .addModifiers(KModifier.OVERRIDE)
            .returns(fd)
            .addStatement("return fromBigDecimal(bigDecimal.abs())")
            .build()
        )
        .addFunction(
          FunSpec.builder("pow")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("exponent", long)
            .returns(fd)
            .addStatement("return fromBigDecimal(bigDecimal.pow(exponent))")
            .build()
        )
        .addFunction(
          FunSpec.builder("pow")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("exponent", int)
            .returns(fd)
            .addStatement("return fromBigDecimal(bigDecimal.pow(exponent))")
            .build()
        )
        .addFunction(
          FunSpec.builder("signum")
            .addModifiers(KModifier.OVERRIDE)
            .returns(int)
            .addStatement("return bigDecimal.signum()")
            .build()
        )
        .addProperty(
          PropertySpec.builder("isNegative", boolean)
            .addModifiers(KModifier.OVERRIDE)
            .getter(FunSpec.getterBuilder().addStatement("return bigDecimal.isNegative").build())
            .build()
        )
        .addProperty(
          PropertySpec.builder("isPositive", boolean)
            .addModifiers(KModifier.OVERRIDE)
            .getter(FunSpec.getterBuilder().addStatement("return bigDecimal.isPositive").build())
            .build()
        )
        .addFunction(
          FunSpec.builder("numberOfDecimalDigits")
            .addModifiers(KModifier.OVERRIDE)
            .returns(long)
            .addStatement("return bigDecimal.numberOfDecimalDigits()")
            .build()
        )
        .addFunction(
          FunSpec.builder("compareTo")
            .addModifiers(KModifier.OVERRIDE, KModifier.OPERATOR)
            .addParameter("other", Any::class.asClassName())
            .returns(int)
            .addStatement(
              "return if (other is FhirDecimal) bigDecimal.compareTo(other.bigDecimal) else " +
                "bigDecimal.compareTo(other)"
            )
            .build()
        )
        .addFunction(
          FunSpec.builder("unaryMinus")
            .addModifiers(KModifier.OVERRIDE, KModifier.OPERATOR)
            .returns(fd)
            .addStatement("return fromBigDecimal(bigDecimal.unaryMinus())")
            .build()
        )
        .addFunction(
          FunSpec.builder("secureOverwrite")
            .addModifiers(KModifier.OVERRIDE)
            .addStatement("bigDecimal.secureOverwrite()")
            .build()
        )
        .addFunction(
          FunSpec.builder("equals")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("other", Any::class.asClassName().copy(nullable = true))
            .returns(boolean)
            .addStatement("return other is FhirDecimal && bigDecimal == other.bigDecimal")
            .build()
        )
        .addFunction(
          FunSpec.builder("hashCode")
            .addModifiers(KModifier.OVERRIDE)
            .returns(int)
            .addStatement("return bigDecimal.hashCode()")
            .build()
        )
        .addFunction(
          FunSpec.builder("toString")
            .addModifiers(KModifier.OVERRIDE)
            .returns(string)
            .addStatement("return wire")
            .build()
        )
        .addFunction(
          FunSpec.builder("toString")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("base", int)
            .returns(string)
            .addStatement("return bigDecimal.toString(base)")
            .build()
        )
        // Interop escape hatch: expose the wrapped arbitrary-precision value. Pairs with the
        // `fromBigDecimal` factory; the backing field itself stays `internal`.
        .addFunction(
          FunSpec.builder("asBigDecimal")
            .addKdoc(
              "Returns the underlying value as an ionspin `BigDecimal` (loses the preserved [wire]" +
                " lexical form; for the exact serialized text call [toString])."
            )
            .returns(bigDecimal)
            .addStatement("return bigDecimal")
            .build()
        )
        // Operator conveniences (CommonBigNumberOperations is internal to bignum).
        .addFunction(operatorOp("plus", "add"))
        .addFunction(operatorOp("minus", "subtract"))
        .addFunction(operatorOp("times", "multiply"))
        .addFunction(operatorOp("div", "divide"))
        .addFunction(operatorOp("rem", "remainder"))
        .build()

    return FileSpec.builder(fd).addType(typeSpec).build()
  }
}
