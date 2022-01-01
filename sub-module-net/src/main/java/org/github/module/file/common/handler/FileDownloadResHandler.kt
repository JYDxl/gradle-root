package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.MAX_LENGTH
import org.github.module.file.common.dto.protocol.FileDownloadRes
import org.github.netty.ops.beforeRelease
import org.springframework.stereotype.Component
import java.io.RandomAccessFile

@Component
class FileDownloadResHandler: BaseHandler<FileDownloadRes>(), ClientMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!
    RandomAccessFile(msg.body.name, "rw").use {
      msg.buf.beforeRelease {readBytes(it.channel, msg.body.offset - 1, msg.body.length.toInt())}
    }
    if (msg.len < MAX_LENGTH - CMD_LENGTH - LEN_LENGTH) {
      ctx.close()
    }
  }
}
