package org.github.module.file.common.dto

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.Channel
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.FILE_DOWNLOAD_RES_MSG_BODY_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.dto.CMD.Companion.parse
import org.github.module.file.common.dto.CMD.FILE_DOWNLOAD_RES
import org.github.module.file.common.dto.protobuf.FileProto.FileDownloadResProto
import org.github.netty.ops.beforeRelease

class FileDownloadRes: CommonMsg<FileDownloadResProto>() {
  lateinit var buf: ByteBuf

  init {
    cmd = FILE_DOWNLOAD_RES
  }

  override fun fill(buf: ByteBuf, channel: Channel) {
    val bodyLen = buf.getInt(CMD_LENGTH + LEN_LENGTH)
    hex = hexDump(buf, 0, CMD_LENGTH + LEN_LENGTH + FILE_DOWNLOAD_RES_MSG_BODY_LENGTH + bodyLen).uppercase()
    cmd = parse(buf.readUnsignedByte().toInt())
    len = buf.readLong()
    cid = channel.id().asShortText()

    buf.readInt()
    buf.readRetainedSlice(bodyLen).beforeRelease {body = FileDownloadResProto.parseFrom(nioBuffer())}

    this.buf = buf.retain()
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    val bytes = body.toByteArray()
    len = FILE_DOWNLOAD_RES_MSG_BODY_LENGTH + bytes.size + body.length

    cid = channel.id().asShortText()
    val head = alloc.buffer(CMD_LENGTH + LEN_LENGTH)
    head.writeByte(cmd.cmd)
    head.writeLong(len)

    val tail = alloc.buffer(FILE_DOWNLOAD_RES_MSG_BODY_LENGTH + bytes.size)
    tail.writeInt(bytes.size)
    tail.writeBytes(bytes)
    return alloc.compositeBuffer(2).addComponents(true, head, tail).apply {hex = hexDump(this).uppercase()}
  }

  override fun toString(): String {
    return super.toString() + "offset=${body.offset - 1}, length=${body.length}, path=${body.path}, "
  }
}
