package org.github.netty.module.log

import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.encodeString
import io.netty.buffer.Unpooled.directBuffer
import io.netty.buffer.Unpooled.unreleasableBuffer
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.socket.DatagramPacket
import io.netty.handler.codec.MessageToMessageEncoder
import java.net.InetSocketAddress
import java.nio.CharBuffer.wrap
import kotlin.text.Charsets.UTF_8

@Sharable
class LogEventEncoder(private val addr: InetSocketAddress): MessageToMessageEncoder<LogEvent>() {
  override fun encode(ctx: ChannelHandlerContext, msg: LogEvent, out: MutableList<Any>) {
    out.add(msg.toBuf(ctx.alloc(), addr))
  }
}

private val sep = unreleasableBuffer(directBuffer(1).writeByte(':'.code))

fun LogEvent.toBuf(alloc: ByteBufAllocator, addr: InetSocketAddress) = DatagramPacket(alloc.compositeBuffer(3).apply {addComponents(true, encodeString(alloc, wrap(this@toBuf.file), UTF_8), sep, encodeString(alloc, wrap(this@toBuf.msg), UTF_8))}, addr)
