package org.github.module.file.common.dto

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.encodeString
import io.netty.channel.Channel
import org.github.module.file.common.dto.CMD.FILE_DOWNLOAD_REQ
import java.nio.CharBuffer.wrap
import kotlin.text.Charsets.UTF_8

class FileDownloadReq(var path: String = ""): Msg(), Input, Output {
  init {
    cmd = FILE_DOWNLOAD_REQ
  }

  override fun fill(buf: ByteBuf, channel: Channel) {
    super.fill(buf, channel)
    path = buf.readCharSequence(len.toInt(), UTF_8).toString()
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    val tail = encodeString(alloc, wrap(path), UTF_8)
    len = tail.readableBytes().toLong()
    val head = super.toByteBuf(alloc, channel)
    return alloc.compositeBuffer(2).addComponents(true, head, tail)
  }

  override fun desc(): String {
    return super.desc() + "path=$path, "
  }
}
