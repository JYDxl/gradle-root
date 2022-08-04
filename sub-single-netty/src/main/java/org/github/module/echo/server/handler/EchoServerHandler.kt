package org.github.module.echo.server.handler

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.EMPTY_BUFFER
import io.netty.channel.ChannelFutureListener.CLOSE
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.debug
import org.github.ops.error
import org.github.ops.log
import kotlin.text.Charsets.UTF_8

@Sharable
class EchoServerHandler: ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = EchoServerHandler::class.log

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as ByteBuf
    log.debug {"Server received: ${msg.toString(UTF_8)}"}
    ctx.write(msg, ctx.voidPromise())
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.writeAndFlush(EMPTY_BUFFER).addListener(CLOSE)
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {}
    ctx.close()
  }
}
