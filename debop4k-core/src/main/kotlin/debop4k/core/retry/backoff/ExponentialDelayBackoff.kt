/*
 * Copyright (c) 2016. Sunghyouk Bae <sunghyouk.bae@gmail.com>
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
 *
 */

package debop4k.core.retry.backoff

import debop4k.core.retry.RetryContext

/**
 * ExponentialDelayBackoff
 * @author debop sunghyouk.bae@gmail.com
 */
class ExponentialDelayBackoff(val initialDelayMillis: Long,
                              val multiplier: Double = DEFAULT_MULTIPLIER) : Backoff {

  init {
    require(initialDelayMillis > 0) {
      "Initial delay must be positive but was: $initialDelayMillis"
    }
  }

  override fun delayMillis(context: RetryContext): Long {
    return (initialDelayMillis * Math.pow(multiplier, (context.retryCount - 1).toDouble())).toLong()
  }

}