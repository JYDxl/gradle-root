package org.github.netty.ops

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.*
import java.nio.CharBuffer.*
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

fun ByteBuf.writeString(str: String, charset: Charset = UTF_8) = writeCharSequence(str, charset)

val ByteBuf.prettyHexDump get() = prettyHexDump(this)!!

fun CharSequence.toByteBuf(alloc: ByteBufAllocator = ALLOC_POOLED) = encodeString(alloc, wrap(this), UTF_8)!!
