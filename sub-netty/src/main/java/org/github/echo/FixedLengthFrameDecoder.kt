package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder

class FixedLengthFrameDecoder(private val frameLen: Int): ByteToMessageDecoder() {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf, out: MutableList<Any>) {
    if(buf.readableBytes() < frameLen) return
    out += buf.readBytes(frameLen)
  }
}
