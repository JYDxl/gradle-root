package org.github.model

import io.vertx.core.buffer.Buffer
import io.vertx.core.json.Json.*

interface BufferAble {
  fun toBuffer() = encodeToBuffer(this)
}

inline fun <reified T: BufferAble> fromBuffer(buffer: Buffer) = decodeValue(buffer, T::class.java)
