package org.github.netty.module.echo.client.handler

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.copiedBuffer
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.core.netty.ops.beforeRelease
import org.github.core.ops.debug
import org.github.core.ops.error
import org.github.core.ops.log
import kotlin.text.Charsets.UTF_8

@Sharable
class EchoClientHandler: ChannelInboundHandlerAdapter() {

  private val log = EchoClientHandler::class.log

  override fun channelActive(ctx: ChannelHandlerContext) {
    ctx.writeAndFlush(copiedBuffer("Netty rocks!", UTF_8))
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as ByteBuf
    msg.beforeRelease {
      log.debug {"Client received: ${toString(UTF_8)}"}
    }
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {}
    ctx.close()
  }
}
