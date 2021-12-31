package org.github.module.file.common.handler

import cn.hutool.core.io.FileUtil.getName
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.DefaultFileRegion
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.FILE_DOWNLOAD_RES_MSG_BODY_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.MAX_LENGTH
import org.github.module.file.common.dto.protocol.FileDownloadReq
import org.github.module.file.common.dto.protocol.FileDownloadRes
import org.github.module.file.common.dto.protocol.protobuf.FileProto
import org.springframework.stereotype.Component
import java.io.RandomAccessFile

@Component
class FileDownloadReqHandler: BaseHandler<FileDownloadReq>(), ServerMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!
    val path = msg.body.path!!
    val file = getName(path)!!
    val bodyLen = FileProto.FileDownloadResProto.newBuilder().setOffset(1).setLength(1).setPath(file).build().toByteArray().size
    val maxFileLen = MAX_LENGTH - (CMD_LENGTH + LEN_LENGTH + FILE_DOWNLOAD_RES_MSG_BODY_LENGTH + bodyLen)
    getFile(path).use {
      val length = it.length()
      val num = length / maxFileLen
      val res = length % maxFileLen
      0.until(num).forEach {idx ->
        val offset = idx * maxFileLen
        ctx.write(FileDownloadRes().apply {body = FileProto.FileDownloadResProto.newBuilder().setOffset(offset + 1).setLength(maxFileLen).setPath(file).build()}, ctx.voidPromise())
        ctx.write(DefaultFileRegion(getFile(path).channel, offset, maxFileLen), ctx.voidPromise())
      }
      val offset = length - res
      ctx.write(FileDownloadRes().apply {body = FileProto.FileDownloadResProto.newBuilder().setOffset(offset + 1).setLength(res).setPath(file).build()}, ctx.voidPromise())
      ctx.write(DefaultFileRegion(getFile(path).channel, offset, res), ctx.voidPromise())
    }
  }

  private fun getFile(path: String) = RandomAccessFile(path, "r")
}
