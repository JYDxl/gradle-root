package org.github.module.file.common.handler

import cn.hutool.core.io.FileUtil.rename
import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.MAX_LENGTH
import org.github.module.file.common.dto.protocol.FileDownloadRes
import org.github.netty.ops.beforeRelease
import org.github.ops.info
import org.github.ops.log
import java.io.File
import java.io.RandomAccessFile

class FileDownloadResHandler: BaseHandler<FileDownloadRes>(), ClientMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!
    val body = msg.body
    val path = body.path
    val tmp = "$path.tmp"
    RandomAccessFile(tmp, "rw").use {
      msg.buf.beforeRelease {readBytes(it.channel, body.offset - 1, body.length.toInt())}
    }
    if (msg.len < MAX_LENGTH - CMD_LENGTH - LEN_LENGTH) {
      rename(File(tmp), path, true)
      log.info {"文件【$path】下载完成"}
    }
  }

  companion object {
    private val log = FileDownloadResHandler::class.log
  }
}
