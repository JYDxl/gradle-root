package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.MAX_LENGTH
import org.github.module.file.common.dto.protocol.FileDownloadRes
import org.github.netty.ops.beforeRelease
import org.github.ops.info
import org.github.ops.log
import org.springframework.stereotype.Component
import java.io.RandomAccessFile

@Component
class FileDownloadResHandler: BaseHandler<FileDownloadRes>(), ClientMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!
    val body = msg.body
    RandomAccessFile(body.name, "rw").use {
      msg.buf.beforeRelease {readBytes(it.channel, body.offset - 1, body.length.toInt())}
    }
    if (msg.len < MAX_LENGTH - CMD_LENGTH - LEN_LENGTH) {
      log.info {"文件【${body.name}】下载成功"}
    }
  }

  companion object {
    private val log = FileDownloadResHandler::class.log
  }
}
