package org.github.ops

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import kotlin.reflect.KClass

fun Logger.trace(ex: Throwable? = null, msg: () -> Any?) = if(isTraceEnabled) msg().let { if(it != Unit) trace(it.toString(), ex) else Unit } else Unit

fun Logger.debug(ex: Throwable? = null, msg: () -> Any?) = if(isDebugEnabled) msg().let { if(it != Unit) debug(it.toString(), ex) else Unit } else Unit

fun Logger.error(ex: Throwable? = null, msg: () -> Any?) = if(isErrorEnabled) msg().let { if(it != Unit) error(it.toString(), ex) else Unit } else Unit

fun Logger.info(ex: Throwable? = null, info: () -> Any?) = if(isInfoEnabled) info().let { if(it != Unit) info(it.toString(), ex) else Unit } else Unit

fun Logger.warn(ex: Throwable? = null, warn: () -> Any?) = if(isWarnEnabled) warn().let { if(it != Unit) warn(it.toString(), ex) else Unit } else Unit

val KClass<*>.log get() = getLogger(java)!!
