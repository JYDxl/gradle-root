package org.github.module.file.client

import cn.hutool.core.io.FileUtil.getName
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import org.github.module.file.common.InputHandler
import org.github.module.file.common.MAX_FILE_SEGMENT_LENGTH
import org.github.module.file.common.dto.FileDownloadReq
import org.github.module.file.common.dto.FileDownloadRes
import org.github.netty.ops.beforeRelease
import org.github.ops.log
import org.slf4j.Logger
import java.io.RandomAccessFile

class ClientHandler(private var path: String = "", override val log: Logger = ClientHandler::class.log): ChannelDuplexHandler(), InputHandler {
  init {
    ensureNotSharable()
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    @Suppress("DEPRECATION")
    super<InputHandler>.exceptionCaught(ctx, cause)
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    super<InputHandler>.channelRead(ctx, msg)
    msg as FileDownloadRes
    RandomAccessFile(path, "rw").use {
      msg.buf.beforeRelease {readBytes(it.channel, msg.offset, msg.length.toInt())}
    }
    if (msg.length < MAX_FILE_SEGMENT_LENGTH) {
      ctx.close()
    }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    super<InputHandler>.channelReadComplete(ctx)
  }

  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    if (msg is FileDownloadReq) {
      path = getName(msg.path)
    }
    super.write(ctx, msg, promise)
  }
}
