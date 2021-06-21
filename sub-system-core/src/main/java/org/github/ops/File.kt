package org.github.ops

import cn.hutool.core.io.FileUtil.getPrefix
import cn.hutool.core.io.FileUtil.getSuffix
import java.io.File

val File.mainName: String get() = getPrefix(this)

val File.extensionName: String get() = getSuffix(this)

val String.mainName: String get() = getPrefix(this)

val String.extensionName: String get() = getSuffix(this)
