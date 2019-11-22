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
          trace(ex?.message, ex)
        }
      }
    } catch(e: Exception) {
      error("Exception in log: ${e.message}", e)
      trace(ex?.message, ex)
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
          debug(ex?.message, ex)
        }
      }
    } catch(e: Exception) {
      error("Exception in log: ${e.message}", e)
      debug(ex?.message, ex)
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
          error(ex?.message, ex)
        }
      }
    } catch(e: Exception) {
      error("Exception in log: ${e.message}", e)
      error(ex?.message, ex)
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
          info(ex?.message, ex)
        }
      }
    } catch(e: Exception) {
      error("Exception in log: ${e.message}", e)
      info(ex?.message, ex)
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
          warn(ex?.message, ex)
        }
      }
    } catch(e: Exception) {
      error("Exception in log: ${e.message}", e)
      warn(ex?.message, ex)
    }
  }
}

val KClass<*>.log get() = getLogger(java)!!
