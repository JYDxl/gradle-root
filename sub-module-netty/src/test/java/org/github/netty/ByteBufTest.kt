package org.github.netty

import io.netty.buffer.Unpooled
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ByteBufTest {
  @Test
  fun testDuplicate() {
    val buf = Unpooled.wrappedBuffer(byteArrayOf(0, 1, 2, 3))
    val duplicate = buf.duplicate()
    duplicate.release()
    assertEquals(0, buf.refCnt())
  }

  @Test
  fun testSlice() {
    val buf = Unpooled.wrappedBuffer(byteArrayOf(0, 1, 2, 3))
    buf.readerIndex(1)
    val slice = buf.slice()
    slice.release()
    assertEquals(0, buf.refCnt())
  }
}
