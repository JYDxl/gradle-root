package org.github.ops

import org.junit.Test

class LoggerOpsTests {
  @Test
  fun testLog() {
    log.trace { null }
    log.info { null }
    log.warn { null }
    log.debug { null }
    log.error { null }
  }

  companion object {
    private val log = LoggerOpsTests::class.log
  }
}
