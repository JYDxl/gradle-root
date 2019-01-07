package org.github.ops

import org.slf4j.Logger

fun Logger.debug(model: Any?) = debug(model.toString())

fun Logger.trace(model: Any?) = trace(model.toString())

fun Logger.error(model: Any?) = error(model.toString())

fun Logger.info(entity: Any?) = info(entity.toString())

fun Logger.warn(entity: Any?) = warn(entity.toString())
