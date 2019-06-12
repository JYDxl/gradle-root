package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

class AbsIntEncoder: MessageToMessageEncoder<ByteBuf>() {
  override fun encode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
    while(msg.readableBytes() >= 4) {
      out += Math.abs(msg.readInt())
    }
  }
}
