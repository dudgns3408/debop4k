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

package debop4k.core.collections.eclipseCollections

import org.eclipse.collections.impl.list.mutable.FastList
import org.eclipse.collections.impl.list.mutable.primitive.*
import org.eclipse.collections.impl.list.primitive.IntInterval
import org.eclipse.collections.impl.map.mutable.UnifiedMap
import org.eclipse.collections.impl.set.mutable.UnifiedSet

//
// Eclipse Collections
//

// Primitive array
//

fun Sequence<Char>.toCharArrayList(): CharArrayList = CharArrayList.newListWith(*this.toList().toCharArray())
fun Iterable<Char>.toCharArrayList(): CharArrayList = this.asSequence().toCharArrayList()
fun CharArray.toCharArrayList(): CharArrayList = CharArrayList.newListWith(*this)
fun CharArrayList.asList(): List<Char> = this.toArray().asList()
fun charArrayListOf(vararg values: Char): CharArrayList = CharArrayList.newListWith(*values)

fun Sequence<Byte>.toByteArrayList(): ByteArrayList = ByteArrayList.newListWith(*this.toList().toByteArray())
fun Iterable<Byte>.toByteArrayList(): ByteArrayList = this.asSequence().toByteArrayList()
fun ByteArray.toByteArrayList(): ByteArrayList = ByteArrayList.newListWith(*this)
fun ByteArrayList.asList(): List<Byte> = this.toArray().asList()
fun byteArrayListOf(vararg values: Byte): ByteArrayList = ByteArrayList.newListWith(*values)

fun Sequence<Short>.toShortArrayList(): ShortArrayList = ShortArrayList.newListWith(*this.toList().toShortArray())
fun Iterable<Short>.toShortArrayList(): ShortArrayList = this.asSequence().toShortArrayList()
fun ShortArray.toShortArrayList(): ShortArrayList = ShortArrayList.newListWith(*this)
fun ShortArrayList.asList(): List<Short> = this.toArray().asList()
fun shortArrayListOf(vararg values: Short): ShortArrayList = ShortArrayList.newListWith(*values)

fun Sequence<Int>.toIntArrayList(): IntArrayList = IntArrayList.newListWith(*this.toList().toIntArray())
fun Iterable<Int>.toIntArrayList(): IntArrayList = this.asSequence().toIntArrayList()
fun IntArray.toIntArrayList(): IntArrayList = IntArrayList.newListWith(*this)
fun IntArrayList.asList(): List<Int> = this.toArray().asList()
fun intArrayListOf(vararg values: Int): IntArrayList = IntArrayList.newListWith(*values)
fun intArrayListOf(iterable: Iterable<Int>): IntArrayList {
  val array = IntArrayList.newListWith()
  iterable.forEach { array.add(it) }
  return array
}

fun Sequence<Long>.toLongArrayList(): LongArrayList = LongArrayList.newListWith(*this.toList().toLongArray())
fun Iterable<Long>.toLongArrayList(): LongArrayList = this.asSequence().toLongArrayList()
fun LongArray.toLongArrayList(): LongArrayList = LongArrayList.newListWith(*this)
fun LongArrayList.asList(): List<Long> = this.toArray().asList()
fun longArrayListOf(vararg values: Long): LongArrayList = LongArrayList.newListWith(*values)

fun Sequence<Float>.toFloatArrayList(): FloatArrayList = FloatArrayList.newListWith(*this.toList().toFloatArray())
fun Iterable<Float>.toFloatArrayList(): FloatArrayList = this.asSequence().toFloatArrayList()
fun FloatArray.toFloatArrayList(): FloatArrayList = FloatArrayList.newListWith(*this)
fun FloatArrayList.asList(): List<Float> = this.toArray().asList()
fun floatArrayListOf(vararg values: Float): FloatArrayList = FloatArrayList.newListWith(*values)

fun Sequence<Double>.toDoubleArrayList(): DoubleArrayList = DoubleArrayList.newListWith(*this.toList().toDoubleArray())
fun Iterable<Double>.toDoubleArrayList(): DoubleArrayList = this.asSequence().toDoubleArrayList()
fun DoubleArray.toDoubleArrayList(): DoubleArrayList = DoubleArrayList.newListWith(*this)
fun DoubleArrayList.asList(): List<Double> = this.toArray().asList()
fun doubleArrayListOf(vararg values: Double): DoubleArrayList = DoubleArrayList.newListWith(*values)


// FastList
//
fun <T> Array<out T>.toFastList(): FastList<T> = FastList.newListWith(*this)

fun <T> emptyFastList() = FastList.newList<T>()
fun <T> fastListOf(): FastList<T> = emptyFastList()
fun <T> fastListOf(vararg elements: T): FastList<T> {
  return if (elements.size == 0) FastList.newList() else FastList.newListWith(*elements)
}

fun <T> fastListOf(iterable: Iterable<T>): FastList<T> = FastList.newList(iterable)

// Unified Set
fun <T> Array<out T>.toUnifiedSet(): UnifiedSet<T> = UnifiedSet.newSetWith(*this)

fun <T> emptyUnifiedSet(): UnifiedSet<T> = UnifiedSet.newSet()
fun <T> unifiedSetOf(): UnifiedSet<T> = emptyUnifiedSet()
fun <T> unifiedSetOf(vararg values: T): UnifiedSet<T> = UnifiedSet.newSetWith(*values)

// Unified Map
//
fun <K, V> Map<K, V>.toUnifiedMap(): UnifiedMap<K, V> {
  val map = UnifiedMap.newMap<K, V>()
  if (this.size > 0) {
    for ((k, v) in this) {
      map.put(k, v)
    }
  }
  return map
}

fun <K, V> unifiedMapOf(vararg pairs: Pair<K, V>): UnifiedMap<K, V> {
  val map = UnifiedMap.newMap<K, V>(pairs.size)
  for ((k, v) in pairs) {
    map.put(k, v)
  }
  return map
}

// Kotlin IntProgress

/**
 * [IntProgression] 을 [IntArrayList] 로 변환
 */
fun IntProgression.toIntArrayList(): IntArrayList {
  return IntArrayList.newList(IntInterval.fromToBy(this.first, this.last, this.step))
}