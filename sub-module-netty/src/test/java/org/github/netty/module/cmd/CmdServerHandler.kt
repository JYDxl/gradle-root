package org.github.netty.module.cmd

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.core.ops.debug
import org.github.core.ops.log

@Sharable
class CmdServerHandler: ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, cmd: Any) {
    cmd as Cmd
    log.debug { cmd }
  }

  companion object {
    /** log. */
    private val log = CmdServerHandler::class.log
  }
}
