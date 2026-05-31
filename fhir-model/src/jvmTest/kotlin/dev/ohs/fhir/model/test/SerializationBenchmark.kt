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

@file:Suppress("DEPRECATION") // FhirR{N}Json is deprecated but is the wrapper under benchmark.

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.FhirR4Json
import dev.ohs.fhir.model.r4b.FhirR4bJson
import dev.ohs.fhir.model.r5.FhirR5Json
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import java.io.File
import kotlin.time.Duration
import kotlin.time.measureTime
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

/**
 * Serialization benchmark over the published HL7 example sets, comparing the streaming
 * custom-serializer decode path against the JSON-tree (`parseToJsonElement` +
 * `decodeFromJsonElement`) path, plus encode. Reports per-op (ns/op) and wall-clock totals.
 *
 * Heavy by design — it decodes every example for R4/R4B/R5 (~11k files) with a warmup. It asserts
 * only that examples were actually exercised; the numbers are printed for inspection.
 */
class SerializationBenchmark :
  FunSpec({
    // Disabled by default (heavy — decodes ~11k examples). Change `xtest` to `test` to run it.
    xtest("serialization benchmark — FhirR{N}Json") {
      val warmup = 5
      val passes = 1

      val r4 = FhirR4Json {
        ignoreUnknownKeys = true
        useAlternativeNames = false
      }
      val r4b = FhirR4bJson {
        ignoreUnknownKeys = true
        useAlternativeNames = false
      }
      val r5 = FhirR5Json {
        ignoreUnknownKeys = true
        useAlternativeNames = false
      }
      val r4Inner = innerJson(r4)
      val r4bInner = innerJson(r4b)
      val r5Inner = innerJson(r5)

      val results =
        listOf(
          runVersion(
            "R4",
            "hl7.fhir.r4.examples",
            warmup,
            passes,
            r4::encodeToString,
            r4::decodeFromString,
            {
              r4Inner.decodeFromJsonElement<dev.ohs.fhir.model.r4.Resource>(
                r4Inner.parseToJsonElement(it)
              )
            },
          ),
          runVersion(
            "R4B",
            "hl7.fhir.r4b.examples",
            warmup,
            passes,
            r4b::encodeToString,
            r4b::decodeFromString,
            {
              r4bInner.decodeFromJsonElement<dev.ohs.fhir.model.r4b.Resource>(
                r4bInner.parseToJsonElement(it)
              )
            },
          ),
          runVersion(
            "R5",
            "hl7.fhir.r5.examples",
            warmup,
            passes,
            r5::encodeToString,
            r5::decodeFromString,
            {
              r5Inner.decodeFromJsonElement<dev.ohs.fhir.model.r5.Resource>(
                r5Inner.parseToJsonElement(it)
              )
            },
          ),
        )

      println(report(results, warmup, passes))

      results.forEach { it.n shouldBeGreaterThan 0 }
    }
  })

private fun innerJson(wrapper: Any): Json {
  val f = wrapper.javaClass.getDeclaredField("json")
  f.isAccessible = true
  return f.get(wrapper) as Json
}

private data class Result(
  val label: String,
  val n: Int,
  val bytes: Long,
  val enc: Duration,
  val dec: Duration,
  val decTree: Duration,
) {
  operator fun plus(o: Result) =
    Result("TOTAL", n + o.n, bytes + o.bytes, enc + o.enc, dec + o.dec, decTree + o.decTree)
}

private fun <R : Any> runVersion(
  label: String,
  pkg: String,
  warmup: Int,
  passes: Int,
  enc: (R) -> String,
  dec: (String) -> R,
  decTree: (String) -> R,
): Result {
  val raws = mutableListOf<String>()
  val models = mutableListOf<R>()
  for ((_, raw) in loadExamples(pkg)) {
    val m = runCatching { dec(raw) }.getOrNull() ?: continue
    raws += raw
    models += m
  }
  require(models.isNotEmpty()) { "$label: no examples decoded" }

  repeat(warmup) {
    for (m in models) enc(m)
    for (s in raws) dec(s)
    for (s in raws) decTree(s)
  }

  return Result(
    label = label,
    n = models.size,
    bytes = raws.sumOf { it.toByteArray(Charsets.UTF_8).size.toLong() },
    enc = measureTime { repeat(passes) { for (m in models) enc(m) } },
    dec = measureTime { repeat(passes) { for (s in raws) dec(s) } },
    decTree = measureTime { repeat(passes) { for (s in raws) decTree(s) } },
  )
}

private fun loadExamples(pkg: String): Sequence<Pair<String, String>> {
  val root =
    System.getProperty("projectRootDir")?.let { File(it) }
      ?: run {
        var d: File? = File("").absoluteFile
        while (d != null && !File(d, "third_party").isDirectory) d = d.parentFile
        d ?: error("no 'third_party' dir found from CWD")
      }
  val dir = File(root, "third_party/$pkg/package")
  require(dir.isDirectory) { "missing $dir" }
  return dir
    .listFiles()!!
    .asSequence()
    .filter { it.name.endsWith(".json") && !it.name.startsWith('.') && it.name != "package.json" }
    .map { it.name to it.readText() }
}

private fun report(rs: List<Result>, warmup: Int, passes: Int): String {
  val total = rs.reduce { a, b -> a + b }
  val labelW = 7
  val samplesW = 7
  val nsW = 11
  val bytesW = 11
  val durW = 13

  fun ns(d: Duration, n: Int) =
    (if (n == 0) "n/a" else (d.inWholeNanoseconds / (n.toLong() * passes)).toString()).padStart(nsW)
  fun row(r: Result) =
    "  ${r.label.padEnd(labelW)} | ${r.n.toString().padStart(samplesW)} | ${ns(r.enc, r.n)} | ${ns(r.dec, r.n)} | ${ns(r.decTree, r.n)}"
  fun totalRow(r: Result) =
    "  ${r.label.padEnd(labelW)} | ${r.bytes.toString().padStart(bytesW)} | ${r.enc.fmt(durW)} | ${r.dec.fmt(durW)} | ${r.decTree.fmt(durW)}"

  val perOpHdr =
    "  ${"Version".padEnd(labelW)} | ${"Samples".padStart(samplesW)} | ${"JSON enc".padStart(nsW)} | ${"JSON dec".padStart(nsW)} | ${"JSON dec(T)".padStart(nsW)}"
  val perOpDiv =
    "  ${"-".repeat(labelW + 1)}+${"-".repeat(samplesW + 2)}+${"-".repeat(nsW + 2)}+${"-".repeat(nsW + 2)}+${"-".repeat(nsW + 1)}"
  val totalsHdr =
    "  ${"Version".padEnd(labelW)} | ${"JSON bytes".padStart(bytesW)} | ${"JSON enc".padStart(durW)} | ${"JSON dec".padStart(durW)} | ${"JSON dec(T)".padStart(durW)}"
  val totalsDiv =
    "  ${"-".repeat(labelW + 1)}+${"-".repeat(bytesW + 2)}+${"-".repeat(durW + 2)}+${"-".repeat(durW + 2)}+${"-".repeat(durW + 1)}"

  return buildString {
    appendLine()
    appendLine("═".repeat(80))
    appendLine("  Serialization benchmark — FhirR{N}Json  [kotest]")
    appendLine("═".repeat(80))
    appendLine("  Samples: all examples  |  Warmup: $warmup  |  Measurement: $passes")
    appendLine(
      "  JSON dec(T) — measures parseToJsonElement(s) + decodeFromJsonElement(elem) (forces tree path)."
    )
    appendLine()
    appendLine("  Per-op (ns/op)")
    appendLine(perOpHdr)
    appendLine(perOpDiv)
    for (r in rs) appendLine(row(r))
    appendLine(perOpDiv)
    appendLine(row(total))
    appendLine()
    appendLine("  Totals (wall-clock)")
    appendLine(totalsHdr)
    appendLine(totalsDiv)
    for (r in rs) appendLine(totalRow(r))
    appendLine(totalsDiv)
    appendLine(totalRow(total))
    appendLine("═".repeat(80))
  }
}

private fun Duration.fmt(w: Int): String = toString().padStart(w)
