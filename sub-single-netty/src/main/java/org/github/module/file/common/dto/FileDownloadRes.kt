package org.github.module.file.common.dto

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.Channel
import org.github.module.file.common.*
import org.github.module.file.common.dto.CMD.Companion.parse
import org.github.module.file.common.dto.CMD.FILE_DOWNLOAD_RES
import kotlin.text.Charsets.UTF_8

class FileDownloadRes(var offset: Long = 0, var length: Long = 0, private var pathLen: Int = 0, var pathName: String = ""): Msg(), Input, Output {
  lateinit var buf: ByteBuf

  init {
    cmd = FILE_DOWNLOAD_RES
  }

  override fun fill(buf: ByteBuf, channel: Channel) {
    pathLen = buf.getInt(CMD_LENGTH + LEN_LENGTH + OFFSET_LENGTH + LENGTH_LENGTH)
    hex = hexDump(buf, 0, CMD_LENGTH + LEN_LENGTH + OFFSET_LENGTH + LENGTH_LENGTH + pathLen).uppercase()
    cmd = parse(buf.readUnsignedByte().toInt())
    len = buf.readLong()
    cid = channel.id().asShortText()

    offset = buf.readLong()
    length = buf.readLong()
    buf.readInt()
    pathName = buf.readCharSequence(pathLen, UTF_8).toString()
    this.buf = buf.retain()
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    len = OFFSET_LENGTH + LENGTH_LENGTH + PATH_LENGTH + pathLen + length
    val head = super.toByteBuf(alloc, channel)
    val tail = alloc.buffer(OFFSET_LENGTH + LENGTH_LENGTH)
    tail.writeLong(offset)
    tail.writeLong(length)
    val path = alloc.buffer(PATH_LENGTH + pathLen)
    path.writeInt(pathLen)
    path.writeCharSequence(pathName, UTF_8)
    return alloc.compositeBuffer(3).addComponents(true, head, tail, path)
  }

  override fun desc(): String {
    return super.desc() + "offset=$offset, length=$length, pathLen=$pathLen, pathName=$pathName"
  }
}
