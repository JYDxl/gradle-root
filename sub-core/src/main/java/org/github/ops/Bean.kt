package org.github.ops

import cn.hutool.core.bean.BeanUtil.copyProperties
import cn.hutool.core.bean.BeanUtil.trimStrFields
import org.github.exception.ParamsErrorException

fun <T: Any> T.trimStrFields(vararg ignore: String = emptyArray()): T = trimStrFields(this, *ignore)

fun <T> T?.notNullAnd(predicate: (T) -> Boolean, msg: () -> String?) = this?.takeIf(predicate) ?: throw ParamsErrorException(msg().toString())

fun <T, R: T> R.copy(entity: T) = apply { copyProperties(entity, this) }
