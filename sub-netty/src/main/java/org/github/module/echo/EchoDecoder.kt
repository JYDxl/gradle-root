package org.github.module.echo

import io.netty.buffer.ByteBuf
import io.netty.handler.codec.Delimiters
import org.github.netty.DelimiterDecoder
import org.github.ops.log
import org.slf4j.Logger

class EchoDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf> = Delimiters.lineDelimiter(), stripDelimiter: Boolean = true, failFast: Boolean = true): DelimiterDecoder(maxFrameLength, delimiters, stripDelimiter, failFast) {
  override val logger: Logger = log

  companion object {
    /** log. */
    private val log = EchoDecoder::class.log
  }
}
