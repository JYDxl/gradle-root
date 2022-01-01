package org.github.module.file.common.dto.protocol

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.Channel
import org.github.module.file.common.CMD_LENGTH
import org.github.module.file.common.LEN_LENGTH
import org.github.module.file.common.dto.protocol.CMD.Companion.parse
import org.github.module.file.common.dto.protocol.CMD.DEFAULT
import org.github.netty.ops.Mark
import org.springframework.context.ApplicationEvent
import kotlin.reflect.KClass

abstract class Msg: Input, Output {
  var cmd: CMD = DEFAULT
  var len: Long = 0
  var hex: String = ""
  var cid: String = ""

  override fun toString(): String {
    return "【${cmd.desc}】 cid=$cid, hex=$hex, cmd=${cmd.cmd}, len=$len, data="
  }

  override fun fill(buf: ByteBuf, channel: Channel) {
    hex = hexDump(buf).uppercase()
    cmd = parse(buf.readUnsignedByte().toInt())
    len = buf.readLong()
    cid = channel.id().asShortText()
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    cid = channel.id().asShortText()
    val buf = alloc.buffer(CMD_LENGTH + LEN_LENGTH)!!
    buf.writeByte(cmd.cmd)
    buf.writeLong(len)
    return buf
  }
}

interface Input {
  fun fill(buf: ByteBuf, channel: Channel)
}

interface Output {
  fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf
}

enum class CMD(val cmd: Int, val desc: String, val clazz: KClass<out Msg>) {
  DEFAULT(0, "默认", CommonMsg::class),
  FILE_DOWNLOAD_REQ(1, "文件下载请求", FileDownloadReq::class),
  FILE_DOWNLOAD_RES(2, "文件下载响应", FileDownloadRes::class),
  LOGIN_REQ(3, "登录请求", LoginReq::class),
  LOGIN_RES(4, "登录响应", LoginRes::class),
  CHAT_REQ(5, "消息请求", ChatReq::class),
  CHAT_RES(6, "消息响应", ChatRes::class),
  ;

  companion object {
    fun parse(cmd: Int) = values().first {it.cmd == cmd}
  }
}

class HeartBeat(source: Mark): ApplicationEvent(source)
