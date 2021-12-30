package org.github.module.file.common

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandler
import org.github.netty.ops.info
import org.github.ops.error
import org.slf4j.Logger

interface InputHandler: ChannelInboundHandler {
  val log: Logger

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {"设备【${ctx.channel().info}】异常: ${cause.message}"}
    ctx.close()
  }
}
