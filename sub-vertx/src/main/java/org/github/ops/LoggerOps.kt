package org.github.ops

import org.slf4j.Logger
import org.slf4j.LoggerFactory.*
import kotlin.reflect.KClass

fun Logger.trace(ex: Throwable? = null, msg: () -> Any?) {
  if(isTraceEnabled) {
    msg().let {
      if(it != Unit) {
        trace(it.toString(), ex)
      } else {
        trace(ex?.message, ex)
      }
    }
  }
}

fun Logger.debug(ex: Throwable? = null, msg: () -> Any?) {
  if(isDebugEnabled) {
    msg().let {
      if(it != Unit) {
        debug(it.toString(), ex)
      } else {
        debug(ex?.message, ex)
      }
    }
  }
}

fun Logger.error(ex: Throwable? = null, msg: () -> Any?) {
  if(isErrorEnabled) {
    msg().let {
      if(it != Unit) {
        error(it.toString(), ex)
      } else {
        error(ex?.message, ex)
      }
    }
  }
}

fun Logger.info(ex: Throwable? = null, msg: () -> Any?) {
  if(isInfoEnabled) {
    msg().let {
      if(it != Unit) {
        info(it.toString(), ex)
      } else {
        info(ex?.message, ex)
      }
    }
  }
}

fun Logger.warn(ex: Throwable? = null, msg: () -> Any?) {
  if(isWarnEnabled) {
    msg().let {
      if(it != Unit) {
        warn(it.toString(), ex)
      } else {
        warn(ex?.message, ex)
      }
    }
  }
}

val KClass<*>.log get() = getLogger(java)!!

val String.log get() = getLogger(this)!!
