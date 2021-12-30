package org.github.module.file.common.dto

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.Channel
import org.github.module.file.common.FILE_RES_LENGTH
import org.github.module.file.common.LENGTH_LENGTH
import org.github.module.file.common.OFFSET_LENGTH
import org.github.module.file.common.dto.CMD.Companion.parse
import org.github.module.file.common.dto.CMD.FILE_DOWNLOAD_RES

class FileDownloadRes(var offset: Long = 0, var length: Long = 0): Msg(), Input, Output {
  lateinit var buf: ByteBuf

  init {
    cmd = FILE_DOWNLOAD_RES
  }

  override fun fill(buf: ByteBuf, channel: Channel) {
    hex = hexDump(buf, 0, FILE_RES_LENGTH).uppercase()
    cmd = parse(buf.readUnsignedByte().toInt())
    len = buf.readLong()
    cid = channel.id().asShortText()

    offset = buf.readLong()
    length = buf.readLong()
    this.buf = buf.retain()
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    len = OFFSET_LENGTH + LENGTH_LENGTH + length
    val head = super.toByteBuf(alloc, channel)
    val tail = alloc.buffer(OFFSET_LENGTH + LENGTH_LENGTH)
    tail.writeLong(offset)
    tail.writeLong(length)
    return alloc.compositeBuffer(2).addComponents(true, head, tail)
  }

  override fun desc(): String {
    return super.desc() + "offset=$offset, length=$length, "
  }
}
