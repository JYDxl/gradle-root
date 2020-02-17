package org.github.ops

import org.junit.jupiter.api.Test

class LoggerOpsKtTest {
  private val log = LoggerOpsKtTest::class.log

  @Test
  fun trace() {
    log.trace {}
    log.trace { "trace" }
    log.trace(RuntimeException()) {}
    log.trace(RuntimeException()) { "trace" }
  }

  @Test
  fun debug() {
  }

  @Test
  fun error() {
  }

  @Test
  fun info() {
  }

  @Test
  fun warn() {
  }
}
