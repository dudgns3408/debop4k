/*
 * Copyright (c) 2016. KESTI co, ltd
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
package debop4k.core.io

import java.io.OutputStream
import java.nio.ByteBuffer

/**
 * ByteBufferOutputStream
 * @author sunghyouk.bae@gmail.com
 */
open class ByteBufferOutputStream internal constructor(val buffer: ByteBuffer) : OutputStream() {

  constructor() : this(DEFAULT_BUFFER_SIZE)
  constructor(capacity: Int) : this(ByteBuffer.allocateDirect(capacity))

  override fun write(b: Int) {
    if (!buffer.hasRemaining()) flush()
    buffer.put(b.toByte())
  }

  override fun write(b: ByteArray?, off: Int, len: Int) {
    if (buffer.remaining() < len) {
      flush()
    }
    buffer.put(b, off, len)
  }

  companion object {
    @JvmStatic
    fun of(src: ByteBuffer): ByteBufferOutputStream {
      val buffer = src.duplicate()
      buffer.flip()
      return ByteBufferOutputStream(buffer)
    }
  }
}