package org.github.ops

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

fun ByteBuf.writeString(str: String, charset: Charset = UTF_8) = writeCharSequence(str, charset)

val ByteBuf.prettyHexDump get() = ByteBufUtil.prettyHexDump(this)!!
