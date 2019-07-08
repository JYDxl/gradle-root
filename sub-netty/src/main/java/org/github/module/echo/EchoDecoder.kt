package org.github.module.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.netty.DecoderInjector
import org.github.ops.log

class EchoDecoder(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxLength, stripDelimiter, failFast), DecoderInjector {
  override val log = EchoDecoder::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}
