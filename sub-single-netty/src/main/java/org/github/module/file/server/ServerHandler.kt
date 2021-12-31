package org.github.module.file.server

import cn.hutool.core.io.FileUtil.getName
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.DefaultFileRegion
import org.github.module.file.common.*
import org.github.module.file.common.dto.FileDownloadReq
import org.github.module.file.common.dto.FileDownloadRes
import org.github.module.file.common.dto.protobuf.FileProto.FileDownloadResProto
import org.github.ops.log
import org.slf4j.Logger
import java.io.RandomAccessFile

@Sharable
class ServerHandler(override val log: Logger = ServerHandler::class.log): ChannelInboundHandlerAdapter(), InputHandler {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as FileDownloadReq
    val path = msg.body.path
    val file = getName(path)
    val bodyLen = FileDownloadResProto.newBuilder().setOffset(1).setLength(1).setPath(file).build().toByteArray().size
    val maxFileLen = MAX_LENGTH - (CMD_LENGTH + LEN_LENGTH + FILE_DOWNLOAD_RES_MSG_BODY_LENGTH + bodyLen)
    getFile(path).use {
      val length = it.length()
      val num = length / maxFileLen
      val res = length % maxFileLen
      0.until(num).forEach {idx ->
        val offset = idx * maxFileLen
        ctx.write(FileDownloadRes().apply {body = FileDownloadResProto.newBuilder().setOffset(offset + 1).setLength(maxFileLen).setPath(file).build()}, ctx.voidPromise())
        ctx.write(DefaultFileRegion(getFile(path).channel, offset, maxFileLen), ctx.voidPromise())
      }
      val offset = length - res
      ctx.write(FileDownloadRes().apply {body = FileDownloadResProto.newBuilder().setOffset(offset + 1).setLength(res).setPath(file).build()}, ctx.voidPromise())
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
