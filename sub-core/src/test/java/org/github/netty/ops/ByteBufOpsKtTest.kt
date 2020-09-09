package org.github.netty.ops

import io.netty.buffer.Unpooled.*
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.text.Charsets.UTF_8

internal class ByteBufOpsKtTest {
  private val log = ByteBufOpsKtTest::class.log

  @Test
  fun writeString() {
    val buf = buffer(4)
    val str = "nico"
    buf.writeString(str)
    assertEquals(str, buf.toString(UTF_8))
  }

  @Test
  fun beforeRelease() {
    val str = "2333"
    val buf = wrappedBuffer(str.toByteArray())
    buf.beforeRelease {
      assertEquals(str, buf.toString(UTF_8))
    }
    log.info { buf }
  }

  @Test
  fun getPrettyHexDump() {
    val buf = wrappedBuffer("2333".toByteArray())
    buf.beforeRelease {
      log.info { buf.prettyHexDump }
    }
  }

  @Test
  fun getHexDump() {
    val buf = wrappedBuffer("2333".toByteArray())
    buf.beforeRelease {
      log.info { buf.hexDump }
    }
  }

  @Test
  fun getALLOC_POOLED() {
    val buf = wrappedBuffer("2333".toByteArray())
    buf.release()
    log.info { buf }
  }

  @Test
  fun getALLOC_UNPOOLED() {
    val buf = wrappedBuffer("2333".toByteArray())
    buf.release()
    log.info { buf }
  }

  @Test
  fun toByteBuf() {
  }
}
