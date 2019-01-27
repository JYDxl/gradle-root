package org.github.ops

import org.slf4j.Logger

fun Logger.info(model: Any?) = info(model.toString())

fun Logger.warn(model: Any?) = warn(model.toString())

fun Logger.debug(model: Any?) = debug(model.toString())

fun Logger.trace(model: Any?) = trace(model.toString())

fun Logger.error(model: Any?) = error(model.toString())
