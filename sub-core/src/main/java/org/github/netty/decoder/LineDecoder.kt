package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder

abstract class LineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}
