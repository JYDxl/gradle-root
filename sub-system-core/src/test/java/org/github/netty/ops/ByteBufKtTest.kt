package org.github.netty.ops

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.wrappedBuffer
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.text.Charsets.UTF_8

internal class ByteBufKtTest {
  private val log = ByteBufKtTest::class.log

  @Test
  fun beforeRelease() {
    val str = "2333"
    val buf: ByteBuf = wrappedBuffer(str.toByteArray())
    buf.beforeRelease {
      assertEquals(str, buf.toString(UTF_8))
    }
    log.info {buf}
  }
}
