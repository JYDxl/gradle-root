package org.github.ops

import com.google.common.base.Strings.padEnd
import com.google.common.base.Strings.padStart
import org.junit.jupiter.api.Test
import java.util.stream.Stream.iterate

internal class StringOpsTest {
  private val log = StringOpsTest::class.log

  @Test
  fun padStart() {
    assert(padStart("2333", 10, ' ') == "      2333")
  }

  @Test
  fun padEnd() {
    assert(padEnd("2333", 10, ' ') == "2333      ")
  }

  @Test
  fun fibonacciSequence() {
    val array = iterate(Node(1, 1)) {Node(it.right, it.left + it.right)}.limit(10).mapToInt {it.left}.toArray()
    log.info {array.contentToString()}
  }
}

internal data class Node(val left: Int, val right: Int)
