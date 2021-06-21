package org.github.netty.ops

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.buffer
import io.netty.buffer.Unpooled.wrappedBuffer
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.text.Charsets.UTF_8

internal class ByteBufKtTest {
  private val log = ByteBufKtTest::class.log

  @Test
  fun writeString() {
    val buf: ByteBuf = buffer(4)
    val str = "nico"
    buf.writeString(str)
    assertEquals(str, buf.toString(UTF_8))
  }

  @Test
  fun beforeRelease() {
    val str = "2333"
    val buf: ByteBuf = wrappedBuffer(str.toByteArray())
    buf.beforeRelease {
      assertEquals(str, buf.toString(UTF_8))
    }
    log.info {buf}
  }

  @Test
  fun getPrettyHexDump() {
    val buf: ByteBuf = wrappedBuffer("2333".toByteArray())
    buf.beforeRelease {
      log.info {buf.prettyHexDump}
    }
  }

  @Test
  fun getHexDump() {
    val buf: ByteBuf = wrappedBuffer("2333".toByteArray())
    buf.beforeRelease {
      log.info {buf.hexDump}
    }
  }

  @Test
  fun getALLOC_POOLED() {
    val buf: ByteBuf = wrappedBuffer("2333".toByteArray())
    buf.release()
    log.info {buf}
  }

  @Test
  fun getALLOC_UNPOOLED() {
    val buf: ByteBuf = wrappedBuffer("2333".toByteArray())
    buf.release()
    log.info {buf}
  }

  @Test
  fun toByteBuf() {
  }
}
