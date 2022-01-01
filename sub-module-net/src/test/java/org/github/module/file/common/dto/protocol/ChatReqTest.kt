package org.github.module.file.common.dto.protocol

import io.netty.buffer.ByteBufAllocator.DEFAULT
import io.netty.channel.embedded.EmbeddedChannel
import org.github.module.file.common.dto.protocol.protobuf.FileProto.ChatReqProto
import org.github.netty.ops.beforeRelease
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Test

internal class ChatReqTest {
  private val log = ChatReqTest::class.log

  @Test
  fun testUser1() {
    val proto = ChatReqProto.newBuilder().setFrom("user1").setContent("2333").setTo("user3").build()!!
    val req = ChatReq().apply {body = proto}
    val buf = req.toByteBuf(DEFAULT, EmbeddedChannel())
    buf.beforeRelease {log.info {req}}
  }

  @Test
  fun testUser2() {
    val proto = ChatReqProto.newBuilder().setFrom("user2").setContent("2333").setTo("user1").build()!!
    val req = ChatReq().apply {body = proto}
    val buf = req.toByteBuf(DEFAULT, EmbeddedChannel())
    buf.beforeRelease {log.info {req}}
  }
}
