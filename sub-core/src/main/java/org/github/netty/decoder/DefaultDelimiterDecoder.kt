package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import org.github.ops.log

class DefaultDelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean = true, failFast: Boolean = true): DelimiterDecoder(maxFrameLength, delimiters, stripDelimiter, failFast) {
  override val logger = log

  override fun failIfNecessary(buf: ByteBuf) {}
}

private val log = DefaultDelimiterDecoder::class.log
