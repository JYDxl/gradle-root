package org.github.module.file.common.dto.protocol

import io.netty.buffer.ByteBufAllocator.DEFAULT
import io.netty.channel.embedded.EmbeddedChannel
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginResProto
import org.github.netty.ops.beforeRelease
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Test

internal class LoginResTest {
  private val log = LoginResTest::class.log

  @Test
  fun testNew() {
    val proto = LoginResProto.newBuilder().setSuccess(true).setMessage("OK").build()!!
    val req = LoginRes().apply {body = proto}
    val buf = req.toByteBuf(DEFAULT, EmbeddedChannel())
    buf.beforeRelease {log.info {req}}
  }
}
