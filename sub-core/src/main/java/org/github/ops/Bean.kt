package org.github.ops

import cn.hutool.core.bean.BeanUtil.trimStrFields

fun <T: Any> T.trimStrFields(vararg ignore: String = emptyArray()): T = trimStrFields(this, *ignore)
