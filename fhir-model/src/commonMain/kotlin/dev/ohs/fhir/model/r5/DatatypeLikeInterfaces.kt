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

import kotlin.Int
import kotlin.collections.List

/**
 * The shared `Element` portion of the FHIR datatype model — `id` and `extension`.
 *
 * Implemented by `Element` (and therefore by every element-shaped type), and extended by each
 * `<Root>Like` family interface.
 */
public interface ElementLike {
  public val id: kotlin.String?

  public val extension: List<Extension>
}

/**
 * Shared shape of the FHIR `Integer` datatype family.
 *
 * Implemented by `Integer` and each of its structural specializations, so callers can read the
 * common fields generically via `x as? IntegerLike` (including the `ElementLike` `id`/`extension`)
 * without those specializations subclassing `Integer`.
 */
public interface IntegerLike : ElementLike {
  public val `value`: Int?
}

/**
 * Shared shape of the FHIR `Quantity` datatype family.
 *
 * Implemented by `Quantity` and each of its structural specializations, so callers can read the
 * common fields generically via `x as? QuantityLike` (including the `ElementLike` `id`/`extension`)
 * without those specializations subclassing `Quantity`.
 */
public interface QuantityLike : ElementLike {
  public val `value`: Decimal?

  public val comparator: Enumeration<Quantity.QuantityComparator>?

  public val unit: String?

  public val system: Uri?

  public val code: Code?
}

/**
 * Shared shape of the FHIR `String` datatype family.
 *
 * Implemented by `String` and each of its structural specializations, so callers can read the
 * common fields generically via `x as? StringLike` (including the `ElementLike` `id`/`extension`)
 * without those specializations subclassing `String`.
 */
public interface StringLike : ElementLike {
  public val `value`: kotlin.String?
}

/**
 * Shared shape of the FHIR `Uri` datatype family.
 *
 * Implemented by `Uri` and each of its structural specializations, so callers can read the common
 * fields generically via `x as? UriLike` (including the `ElementLike` `id`/`extension`) without
 * those specializations subclassing `Uri`.
 */
public interface UriLike : ElementLike {
  public val `value`: kotlin.String?
}
