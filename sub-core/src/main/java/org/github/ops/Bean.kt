package org.github.ops

import cn.hutool.core.bean.BeanUtil.trimStrFields

fun <T: Any> T.trim(vararg ignore: String): T = trimStrFields(this, *ignore)

fun <T: Any> T.trim(): T = trimStrFields(this)
