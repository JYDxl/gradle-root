package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.DefaultFileRegion
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.FILE_DOWNLOAD_RES_MSG_BODY_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.MAX_LENGTH
import org.github.module.file.common.dto.protocol.FileDownloadReq
import org.github.module.file.common.dto.protocol.FileDownloadRes
import org.github.module.file.common.dto.protocol.protobuf.FileProto.FileDownloadResProto
import org.springframework.stereotype.Component
import java.io.RandomAccessFile

@Component
class FileDownloadReqHandler: BaseHandler<FileDownloadReq>(), ServerMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!.body
    val src = msg.src!!
    val oldOffset = msg.offset
    val path = msg.des!!
    val bodyLen = FileDownloadResProto.newBuilder().setOffset(1).setLength(1).setPath(path).build().toByteArray().size
    val maxFileLen = MAX_LENGTH - (CMD_LENGTH + LEN_LENGTH + FILE_DOWNLOAD_RES_MSG_BODY_LENGTH + bodyLen)
    getFile(src).use {
      val length = it.length() - oldOffset
      val num = length / maxFileLen
      val res = length % maxFileLen
      0.until(num).forEach {idx ->
        val newOffset = idx * maxFileLen + oldOffset
        ctx.write(FileDownloadRes().apply {body = FileDownloadResProto.newBuilder().setOffset(newOffset + 1).setLength(maxFileLen).setPath(path).build()}, ctx.voidPromise())
        ctx.write(DefaultFileRegion(getFile(src).channel, newOffset, maxFileLen), ctx.voidPromise())
      }
      val newOffset = length - res + oldOffset
      ctx.write(FileDownloadRes().apply {body = FileDownloadResProto.newBuilder().setOffset(newOffset + 1).setLength(res).setPath(path).build()}, ctx.voidPromise())
      ctx.write(DefaultFileRegion(getFile(src).channel, newOffset, res), ctx.voidPromise())
    }
  }

  private fun getFile(path: String) = RandomAccessFile(path, "r")
}
