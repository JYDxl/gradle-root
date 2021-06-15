package org.github.ops

import cn.hutool.core.lang.Validator.hasChinese
import cn.hutool.core.util.StrUtil.isNotBlank

fun String?.isNotBlank() = isNotBlank(this)

fun String?.hasChinese() = hasChinese(this)
