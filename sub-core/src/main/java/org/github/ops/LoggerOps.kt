package org.github.ops

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import kotlin.reflect.KClass

fun Logger.trace(ex: Throwable? = null, msg: () -> String?) = if(isTraceEnabled) trace(msg(), ex) else Unit

fun Logger.debug(ex: Throwable? = null, msg: () -> String?) = if(isDebugEnabled) debug(msg(), ex) else Unit

fun Logger.error(ex: Throwable? = null, msg: () -> String?) = if(isErrorEnabled) error(msg(), ex) else Unit

fun Logger.info(ex: Throwable? = null, info: () -> String?) = if(isInfoEnabled) info(info(), ex) else Unit

fun Logger.warn(ex: Throwable? = null, warn: () -> String?) = if(isWarnEnabled) warn(warn(), ex) else Unit

val KClass<*>.log get() = getLogger(java)!!
