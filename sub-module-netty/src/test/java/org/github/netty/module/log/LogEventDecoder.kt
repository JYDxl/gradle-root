package org.github.netty.module.log

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.socket.DatagramPacket
import io.netty.handler.codec.MessageToMessageDecoder
import io.netty.util.CharsetUtil.*

@Sharable
class LogEventDecoder: MessageToMessageDecoder<DatagramPacket>() {
  override fun decode(ctx: ChannelHandlerContext, dp: DatagramPacket, out: MutableList<Any>) {
    val line = dp.content().toString(UTF_8)
    val (file, msg) = line.split(":", limit = 2)
    out.add(LogEvent(dp.sender(), file, msg))
  }
}
