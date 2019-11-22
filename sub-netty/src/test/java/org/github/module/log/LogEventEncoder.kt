package org.github.module.log

import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.Unpooled.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.socket.DatagramPacket
import io.netty.handler.codec.MessageToMessageEncoder
import org.github.netty.ops.toByteBuf
import java.net.InetSocketAddress

@Sharable
class LogEventEncoder(private val addr: InetSocketAddress): MessageToMessageEncoder<LogEvent>() {
  override fun encode(ctx: ChannelHandlerContext, msg: LogEvent, out: MutableList<Any>) {
    out.add(msg.toBuf(ctx.alloc(), addr))
  }
}

private val sep = unreleasableBuffer(directBuffer(1).writeByte(':'.toInt()))!!

fun LogEvent.toBuf(alloc: ByteBufAllocator, addr: InetSocketAddress) = DatagramPacket(alloc.compositeBuffer(3)!!.apply { addComponents(true, this@toBuf.file.toByteBuf(alloc), sep, this@toBuf.msg.toByteBuf(alloc)) }, addr)
