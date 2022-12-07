package org.github.netty.module.cmd

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder
import io.netty.util.CharsetUtil.*

@Sharable
class CmdDecoder: MessageToMessageDecoder<ByteBuf>() {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf, out: MutableList<Any>) {
    val msg = buf.toString(UTF_8)
    val ary = msg.split(' ')
    out.add(Cmd(ary[0], ary.subList(1, ary.size)))
  }
}
