package org.github.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.netty.DecoderInjector
import org.github.ops.log

class LineDecoderWithPreChecker(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxLength, stripDelimiter, failFast), DecoderInjector {
  override val logger = log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }

  companion object {
    /** log. */
    private val log = LineDecoderWithPreChecker::class.log
  }
}
