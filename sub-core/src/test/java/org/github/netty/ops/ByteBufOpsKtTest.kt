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
    val buf = str.toByteBuf()
    buf.beforeRelease {
      assertEquals(str, buf.toString(UTF_8))
    }
    log.info { buf }
  }

  @Test
  fun getPrettyHexDump() {
    val buf = "2333".toByteBuf()
    buf.beforeRelease {
      log.info { buf.prettyHexDump }
    }
  }

  @Test
  fun getHexDump() {
    val buf = "2333".toByteBuf()
    buf.beforeRelease {
      log.info { buf.hexDump }
    }
  }

  @Test
  fun getALLOC_POOLED() {
    val buf = "2333".toByteBuf(ALLOC_POOLED)
    buf.release()
    log.info { buf }
  }

  @Test
  fun getALLOC_UNPOOLED() {
    val buf = "2333".toByteBuf(ALLOC_UNPOOLED)
    buf.release()
    log.info { buf }
  }

  @Test
  fun toByteBuf() {
  }
}
