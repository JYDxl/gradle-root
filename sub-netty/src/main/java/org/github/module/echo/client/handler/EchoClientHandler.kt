package org.github.module.echo.client.handler

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.netty.ops.beforeRelease
import org.github.ops.debug
import org.github.ops.error
import org.github.ops.log
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
      log.debug { "Client received: ${toString(UTF_8)}" }
    }
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {}
    ctx.close()
  }
}
