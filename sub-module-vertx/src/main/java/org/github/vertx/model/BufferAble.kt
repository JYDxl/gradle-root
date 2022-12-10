package org.github.vertx.model

import io.vertx.core.buffer.Buffer
import io.vertx.core.json.Json.decodeValue
import io.vertx.core.json.Json.encodeToBuffer

interface BufferAble {
  fun toBuffer(): Buffer = encodeToBuffer(this)
}

inline fun <reified T: BufferAble> fromBuffer(buffer: Buffer): T = decodeValue(buffer, T::class.java)
