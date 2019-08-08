package org.github.netty

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import org.github.ops.log

open class DelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean = true, failFast: Boolean = true): DelimiterBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast, *delimiters), DecoderInjector {
  override val logger = log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }

  companion object {
    private val log = DelimiterDecoder::class.log
  }
}
