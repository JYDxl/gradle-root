package org.github.netty

import io.netty.buffer.Unpooled
import org.github.core.ops.debug
import org.github.core.ops.log
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ByteBufProcessorTest {
  /** log. */
  private val log = ByteBufProcessorTest::class.log

  @Test
  fun test() {
    val byteBuf = Unpooled.wrappedBuffer(byteArrayOf(0, 1, 2, 3))
    val index1 = byteBuf.forEachByte {true.apply {log.debug {it}}}
    assertEquals(-1, index1)
    val index2 = byteBuf.forEachByte {it.toInt() != 0}
    assertEquals(0, index2)
    val index3 = byteBuf.forEachByte {it.toInt() == 0}
    assertEquals(1, index3)
  }
}
