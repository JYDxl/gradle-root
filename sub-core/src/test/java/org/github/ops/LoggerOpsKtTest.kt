package org.github.ops

import org.junit.jupiter.api.Test

internal class LoggerOpsKtTest {
  private val log = LoggerOpsKtTest::class.log

  @Test
  fun trace() {
    log.trace { }
    log.trace {"Hello world!"}
    log.trace {throw IllegalStateException()}
    log.trace(IllegalStateException()) {}
  }

  @Test
  fun debug() {
    log.debug { }
    log.debug {"Hello world!"}
    log.debug {throw IllegalStateException()}
    log.debug(IllegalStateException()) {}
  }

  @Test
  fun error() {
    log.error { }
    log.error {"Hello world!"}
    log.error {throw IllegalStateException()}
    log.error(IllegalStateException()) {}
  }

  @Test
  fun info() {
    log.info { }
    log.info {"Hello world!"}
    log.info {throw IllegalStateException()}
    log.info(IllegalStateException()) {}
  }

  @Test
  fun warn() {
    log.warn { }
    log.warn {"Hello world!"}
    log.warn {throw IllegalStateException()}
    log.warn(IllegalStateException()) {}
  }
}
