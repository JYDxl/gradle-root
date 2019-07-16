package org.github.netty

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DelimiterBasedFrameDecoder

abstract class DelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean = true, failFast: Boolean = true): DelimiterBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast, *delimiters), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}
