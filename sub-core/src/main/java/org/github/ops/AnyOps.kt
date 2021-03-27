package org.github.ops

import org.github.exception.ParamsErrorException
import org.slf4j.LoggerFactory.getLogger

fun check(preCondition: () -> Boolean, lazyMessage: () -> Any) {
  val value = try {
    preCondition()
  } catch (e: Exception) {
    log.error(e) { "precondition方法中发生异常: ${e.message}" }
    false
  }
  try {
    require(value, lazyMessage)
  } catch (e: IllegalArgumentException) {
    throw ParamsErrorException(e)
  } catch (e: Exception) {
    log.error(e) { "lazyMessage方法中发生异常: ${e.message}" }
    throw ParamsErrorException(e)
  }
}

private val log = getLogger("org.github.Any")
