package org.github.module.file.client

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.InputHandler
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.MAX_LENGTH
import org.github.module.file.common.dto.FileDownloadRes
import org.github.netty.ops.beforeRelease
import org.github.ops.log
import org.slf4j.Logger
import java.io.RandomAccessFile

@Sharable
class ClientHandler(override val log: Logger = ClientHandler::class.log): ChannelInboundHandlerAdapter(), InputHandler {
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    @Suppress("DEPRECATION")
    super<InputHandler>.exceptionCaught(ctx, cause)
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    super<InputHandler>.channelRead(ctx, msg)
    msg as FileDownloadRes
    RandomAccessFile(msg.pathName, "rw").use {
      msg.buf.beforeRelease {readBytes(it.channel, msg.offset, msg.length.toInt())}
    }
    if (msg.len < MAX_LENGTH - CMD_LENGTH - LEN_LENGTH) {
      ctx.close()
    }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    super<InputHandler>.channelReadComplete(ctx)
  }
}
