package org.github.module.file.server

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.DefaultFileRegion
import org.github.module.file.client.ClientHandler
import org.github.module.file.common.InputHandler
import org.github.module.file.common.MAX_FILE_SEGMENT_LENGTH
import org.github.module.file.common.dto.FileDownloadReq
import org.github.module.file.common.dto.FileDownloadRes
import org.github.ops.log
import org.slf4j.Logger
import java.io.RandomAccessFile

@Sharable
class ServerHandler(override val log: Logger = ClientHandler::class.log): ChannelInboundHandlerAdapter(), InputHandler {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    super<InputHandler>.channelRead(ctx, msg)
    msg as FileDownloadReq
    val path = msg.path
    getFile(path).use {
      val length = it.length()
      val num = length / MAX_FILE_SEGMENT_LENGTH
      val res = length % MAX_FILE_SEGMENT_LENGTH
      0.until(num).forEach {idx ->
        val offset = idx * MAX_FILE_SEGMENT_LENGTH
        ctx.write(FileDownloadRes(offset, MAX_FILE_SEGMENT_LENGTH), ctx.voidPromise())
        ctx.write(DefaultFileRegion(getFile(path).channel, offset, MAX_FILE_SEGMENT_LENGTH), ctx.voidPromise())
      }
      val offset = length - res
      ctx.write(FileDownloadRes(offset, res), ctx.voidPromise())
      ctx.write(DefaultFileRegion(getFile(path).channel, offset, res), ctx.voidPromise())
    }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    super<InputHandler>.channelReadComplete(ctx)
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    @Suppress("DEPRECATION")
    super<InputHandler>.exceptionCaught(ctx, cause)
  }

  private fun getFile(path: String) = RandomAccessFile(path, "r")
}
