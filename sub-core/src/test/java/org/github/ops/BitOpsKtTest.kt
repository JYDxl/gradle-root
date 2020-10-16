package org.github.ops

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class BitOpsKtTest {
  @Test
  fun lastN() {
    val head = 0x11111111
    val tail = 0x11111111
    assertEquals(head.lastN(1), tail.lastN(1))
    assertEquals(head.lastN(2), tail.lastN(2))
    assertEquals(head.lastN(3), tail.lastN(3))
    assertEquals(head.lastN(4), tail.lastN(4))
  }

  @Test
  fun testLastN() {
  }
}
