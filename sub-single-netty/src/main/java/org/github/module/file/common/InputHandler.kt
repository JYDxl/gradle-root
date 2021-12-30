package org.github.module.file.common

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandler
import org.github.module.file.common.dto.Msg
import org.github.netty.ops.info
import org.github.ops.error
import org.github.ops.info
import org.slf4j.Logger

interface InputHandler: ChannelInboundHandler {
  val log: Logger

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    if (msg is Msg) {
      log.info {"从设备【${ctx.channel().info}】接收到数据: ${msg.desc()}"}
    }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {"设备【${ctx.channel().info}】异常: ${cause.message}"}
    ctx.close()
  }
}
