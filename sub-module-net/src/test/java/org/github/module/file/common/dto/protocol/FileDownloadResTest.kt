package org.github.module.file.common.dto.protocol

import io.netty.buffer.ByteBufAllocator.DEFAULT
import io.netty.channel.embedded.EmbeddedChannel
import org.github.module.file.common.dto.protocol.protobuf.FileProto.FileDownloadResProto
import org.github.netty.ops.beforeRelease
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Test

internal class FileDownloadResTest {
  private val log = FileDownloadResTest::class.log

  @Test
  fun testNew() {
    val proto = FileDownloadResProto.newBuilder().setName("test.txt").setOffset(0).setLength(100).build()!!
    val req = FileDownloadRes().apply {body = proto}
    val buf = req.toByteBuf(DEFAULT, EmbeddedChannel())
    buf.beforeRelease {log.info {req}}
  }
}
