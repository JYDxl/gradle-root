package org.github.ops

import org.slf4j.Logger
import org.slf4j.LoggerFactory.*
import kotlin.reflect.KClass

fun Logger.trace(ex: Throwable? = null, msg: () -> Any?) {
  if(isTraceEnabled) {
    try {
      msg().let {
        if(it != Unit) {
          trace(it.toString(), ex)
        } else {
          ex?.apply { trace(message, this) }
        }
      }
    } catch(e: Exception) {
      error("Exception in msg func: ${e.message}", e)
      ex?.apply { trace(message, this) }
    }
  }
}

fun Logger.debug(ex: Throwable? = null, msg: () -> Any?) {
  if(isDebugEnabled) {
    try {
      msg().let {
        if(it != Unit) {
          debug(it.toString(), ex)
        } else {
          ex?.apply { debug(message, this) }
        }
      }
    } catch(e: Exception) {
      error("Exception in msg func: ${e.message}", e)
      ex?.apply { debug(message, this) }
    }
  }
}

fun Logger.error(ex: Throwable? = null, msg: () -> Any?) {
  if(isErrorEnabled) {
    try {
      msg().let {
        if(it != Unit) {
          error(it.toString(), ex)
        } else {
          ex?.apply { error(message, this) }
        }
      }
    } catch(e: Exception) {
      error("Exception in msg func: ${e.message}", e)
      ex?.apply { error(message, this) }
    }
  }
}

fun Logger.info(ex: Throwable? = null, msg: () -> Any?) {
  if(isInfoEnabled) {
    try {
      msg().let {
        if(it != Unit) {
          info(it.toString(), ex)
        } else {
          ex?.apply { info(message, this) }
        }
      }
    } catch(e: Exception) {
      error("Exception in msg func: ${e.message}", e)
      ex?.apply { info(message, this) }
    }
  }
}

fun Logger.warn(ex: Throwable? = null, msg: () -> Any?) {
  if(isWarnEnabled) {
    try {
      msg().let {
        if(it != Unit) {
          warn(it.toString(), ex)
        } else {
          ex?.apply { warn(message, this) }
        }
      }
    } catch(e: Exception) {
      error("Exception in msg func: ${e.message}", e)
      ex?.apply { warn(message, this) }
    }
  }
}

val KClass<*>.log: Logger get() = getLogger(java)
