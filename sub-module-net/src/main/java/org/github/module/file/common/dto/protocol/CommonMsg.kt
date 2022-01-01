package org.github.module.file.common.dto.protocol

import cn.hutool.core.util.ReflectUtil.getMethod
import cn.hutool.core.util.ReflectUtil.invokeStatic
import com.google.protobuf.Message
import com.google.protobuf.util.JsonFormat.printer
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.Channel
import java.lang.reflect.ParameterizedType
import java.nio.ByteBuffer

open class CommonMsg<T: Message>: Msg(), Input, Output {
  private val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<*>

  lateinit var body: T

  override fun fill(buf: ByteBuf, channel: Channel) {
    super.fill(buf, channel)
    body = invokeStatic(getMethod(type, "parseFrom", ByteBuffer::class.java), buf.nioBuffer())
  }

  override fun toByteBuf(alloc: ByteBufAllocator, channel: Channel): ByteBuf {
    val bytes = body.toByteArray()!!
    len = bytes.size.toLong()
    val tail = alloc.buffer(len.toInt())!!
    tail.writeBytes(bytes)
    val head = super.toByteBuf(alloc, channel)
    return alloc.compositeBuffer(2).addComponents(true, head, tail).apply {hex = hexDump(this).uppercase()}
  }

  override fun toString(): String {
    return super.toString() + printer().print(body)
  }
}
