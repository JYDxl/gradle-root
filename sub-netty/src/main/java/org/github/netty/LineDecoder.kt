package org.github.netty

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.ops.log

open class LineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override val logger = log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }

  companion object {
    private val log = LineDecoder::class.log
  }
}
