package org.github.module.file.common.dto.protocol

import io.netty.buffer.ByteBufAllocator.DEFAULT
import io.netty.channel.embedded.EmbeddedChannel
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginReqProto
import org.github.netty.ops.beforeRelease
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Test

internal class LoginReqTest {
  private val log = LoginReqTest::class.log

  @Test
  fun user1() {
    val proto = LoginReqProto.newBuilder().setUsername("user1").setPassword("user1").build()!!
    val req = LoginReq().apply {body = proto}
    val buf = req.toByteBuf(DEFAULT, EmbeddedChannel())
    buf.beforeRelease {log.info {req}}
  }

  @Test
  fun user2() {
    val proto = LoginReqProto.newBuilder().setUsername("user2").setPassword("user2").build()!!
    val req = LoginReq().apply {body = proto}
    val buf = req.toByteBuf(DEFAULT, EmbeddedChannel())
    buf.beforeRelease {log.info {req}}
  }
}
