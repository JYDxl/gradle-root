@file:Suppress("UNCHECKED_CAST")

package org.github.ops

import cn.hutool.core.bean.BeanUtil.copyProperties
import org.github.base.IParam
import org.github.exception.ParamsErrorException

fun <T> T?.notNullAnd(predicate: (T) -> Boolean = {true}, msg: () -> String?) = this?.takeIf(predicate) ?: throw ParamsErrorException(msg().toString())

fun <T, R: T> R.copy(entity: T) = apply {copyProperties(entity, this)}

fun <T: IParam> T.trim(): T = this.also {trimFields(); valid()}
