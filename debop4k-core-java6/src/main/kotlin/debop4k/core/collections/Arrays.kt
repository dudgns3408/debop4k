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

package debop4k.core.collections

val emptyCharArray: CharArray get() = CharArray(0)
val emptyByteArray: ByteArray get() = ByteArray(0)
val emptyShortArray: ShortArray get() = ShortArray(0)
val emptyIntArray: IntArray get() = IntArray(0)
val emptyLongArray: LongArray get() = LongArray(0)
val emptyFloatArray: FloatArray get() = FloatArray(0)
val emptyDoubleArray: DoubleArray get() = DoubleArray(0)
val emptyStringArray: Array<String> get() = arrayOf<String>()

val CharArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val ByteArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val ShortArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val IntArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val LongArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val FloatArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val DoubleArray?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()
val Array<*>?.isNullOrEmpty: Boolean get() = this == null || this.isEmpty()

val CharArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val ByteArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val ShortArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val IntArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val LongArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val FloatArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val DoubleArray?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()
val Array<*>?.nonEmpty: Boolean get() = this != null && this.isNotEmpty()


