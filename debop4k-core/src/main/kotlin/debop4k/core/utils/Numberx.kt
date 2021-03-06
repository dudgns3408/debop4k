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
@file:JvmName("Numberx")

package debop4k.core.utils

import org.springframework.util.NumberUtils
import java.text.DecimalFormat
import java.text.NumberFormat

infix fun Int.min(other: Int): Int = Math.min(this, other)
infix fun Int.max(other: Int): Int = Math.max(this, other)
fun Int.coerce(min: Int, max: Int): Int = this.min(min).max(max)
fun Int.coerce(range: IntRange): Int = this.coerce(range.start, range.endInclusive)


infix fun Long.min(other: Long): Long = Math.min(this, other)
infix fun Long.max(other: Long): Long = Math.max(this, other)
fun Long.coerce(min: Long, max: Long): Long = this.min(min).max(max)
fun Long.coerce(range: LongRange): Long = this.coerce(range.start, range.endInclusive)

infix fun Byte.min(other: Byte): Byte = if (this < other) this else other
infix fun Byte.max(other: Byte): Byte = if (this > other) this else other
fun Byte.coerce(min: Byte, max: Byte): Byte = this.min(min).max(max)
fun Byte.coerce(range: IntRange): Byte = this.coerce(range.start.toByte(), range.endInclusive.toByte())


infix fun Short.min(other: Short): Short = if (this < other) this else other
infix fun Short.max(other: Short): Short = if (this > other) this else other
fun Short.coerce(min: Short, max: Short): Short = this.min(min).max(max)
fun Short.coerce(range: IntRange): Short = this.coerce(range.start.toShort(), range.endInclusive.toShort())

infix fun Float.min(other: Float): Float = Math.min(this, other)
infix fun Float.max(other: Float): Float = Math.max(this, other)
fun Float.coerce(min: Float, max: Float): Float = this.min(min).max(max)

infix fun Double.min(other: Double): Double = Math.min(this, other)
infix fun Double.max(other: Double): Double = Math.max(this, other)
fun Double.coerce(min: Double, max: Double): Double = this.min(min).max(max)


val DEFAULT_DECIMAL_FORMAT: DecimalFormat = DecimalFormat("#,##0.#")
/**
 * 숫자를 인간이 보기 편하도록 보여준다
 */
fun Number.toHuman(): String = DEFAULT_DECIMAL_FORMAT.format(this.toDouble())


// SpringFramework 의  NumberUtils

fun <T : Number> Number.toTargetClass(clazz: Class<T>): T
    = NumberUtils.convertNumberToTargetClass(this, clazz)

fun <T : Number> String.parseNumber(clazz: Class<T>): T
    = NumberUtils.parseNumber(this, clazz)

fun <T : Number> String.parseNumber(clazz: Class<T>, format: NumberFormat): T
    = NumberUtils.parseNumber(this, clazz, format)