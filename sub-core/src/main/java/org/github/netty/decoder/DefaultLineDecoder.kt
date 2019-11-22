package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import org.github.ops.log

class DefaultLineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override val logger = log

  override fun failIfNecessary(buf: ByteBuf) {}
}

private val log = DefaultLineDecoder::class.log
