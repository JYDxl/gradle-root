package org.github.module.file.common.dto

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.channel.Channel
import org.github.module.file.common.dto.CMD.FILE_DOWNLOAD_REQ
import org.github.module.file.common.dto.protobuf.FileProto.FileDownloadReqProto
import org.github.module.file.common.dto.protobuf.FileProto.FileDownloadReqProto.parseFrom

class FileDownloadReq: Msg(), Input, Output {
  lateinit var body: FileDownloadReqProto

  init {
    cmd = FILE_DOWNLOAD_REQ
  }

  override fun fill(buf: ByteBuf, channel: Channel) {
    super.fill(buf, channel)
    body = parseFrom(buf.nioBuffer())
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    val bytes = body.toByteArray()
    len = bytes.size.toLong()
    val tail = alloc.buffer(len.toInt())
    tail.writeBytes(bytes)
    val head = super.toByteBuf(alloc, channel)
    return alloc.compositeBuffer(2).addComponents(true, head, tail)
  }

  override fun desc(): String {
    return super.desc() + "path=${body.path}, "
  }
}
