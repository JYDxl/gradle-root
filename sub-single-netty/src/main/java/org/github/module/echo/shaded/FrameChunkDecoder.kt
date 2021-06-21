package org.github.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import io.netty.handler.codec.TooLongFrameException

class FrameChunkDecoder(private val maxLen: Int): ByteToMessageDecoder() {
  override fun decode(ctx: ChannelHandlerContext, input: ByteBuf, out: MutableList<Any>) {
    val readableBytes = input.readableBytes()
    if(readableBytes > maxLen) {
      input.clear()
      throw TooLongFrameException("$readableBytes")
    }
    out.add(input.readRetainedSlice(readableBytes))
  }
}
