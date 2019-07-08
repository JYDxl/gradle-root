package org.github.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.netty.DecoderInjector
import org.github.ops.log

class LineDecoderWithPreChecker(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxLength, stripDelimiter, failFast), DecoderInjector {
  /** log. */
  override val log = LineDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}
