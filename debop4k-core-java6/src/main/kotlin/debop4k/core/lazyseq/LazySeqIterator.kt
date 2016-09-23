/*
 * Copyright (c) 2016. Sunghyouk Bae <sunghyouk.bae@gmail.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package debop4k.core.lazyseq

/**
 * LazySeqIterator
 * @author sunghyouk.bae@gmail.com
 */
class LazySeqIterator<E>(var underlying: LazySeq<E>) : MutableIterator<E> {

  override fun hasNext(): Boolean = !underlying.isEmpty()

  override fun next(): E {
    val next = underlying.head
    underlying = underlying.tail
    return next
  }

  override fun remove() {
    throw UnsupportedOperationException("remove")
  }

  inline fun forEachRemaining(action: (E) -> Unit): Unit {
    underlying.forEach(action)
  }
}