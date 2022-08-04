package org.github.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.info
import org.github.ops.log

class EchoClientHandler: ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = EchoClientHandler::class.log

  override fun channelActive(ctx: ChannelHandlerContext) {
    val buffer = Unpooled.buffer()
    buffer.writeShortLE(8)
    buffer.writeShortLE(0x2001)
    buffer.writeIntLE(0x1000005)
    ctx.writeAndFlush(buffer)
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    log.info {ByteBufUtil.hexDump(msg as ByteBuf)}
    val buffer = Unpooled.buffer(6)
    buffer.writeShortLE(6)
    buffer.writeShortLE(0x2222)
    buffer.writeShortLE(0)
    ctx.writeAndFlush(buffer)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    cause.printStackTrace()
    ctx.close()
  }
}
