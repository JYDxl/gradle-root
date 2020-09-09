package org.github.netty.ops

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil.*
import io.netty.buffer.PooledByteBufAllocator
import io.netty.buffer.UnpooledByteBufAllocator
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

fun ByteBuf.writeString(str: CharSequence, charset: Charset = UTF_8) = writeCharSequence(str, charset)

fun ByteBuf.beforeRelease(block: ByteBuf.() -> Unit) = try {
  apply(block)
} finally {
  release()
}

val ByteBuf.prettyHexDump: String get() = prettyHexDump(this)

val ByteBuf.hexDump: String get() = hexDump(this)

val ALLOC_POOLED: PooledByteBufAllocator = PooledByteBufAllocator.DEFAULT

val ALLOC_UNPOOLED: UnpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT
