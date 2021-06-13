package org.github.ops

import cn.hutool.core.util.StrUtil.isNotBlank
import org.github.exception.ParamsErrorException

fun String?.isNotBlank() = isNotBlank(this)

fun <T> T?.notNullAnd(predicate: (T) -> Boolean, msg: () -> String?) = this?.takeIf(predicate) ?: throw ParamsErrorException(msg().toString())
