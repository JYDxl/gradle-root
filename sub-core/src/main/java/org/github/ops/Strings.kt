package org.github.ops

import com.google.common.io.BaseEncoding.base16
import java.io.File
import java.lang.ClassLoader.getSystemResource

val String.hexBytes: ByteArray get() = base16().decode(toUpperCase())

val String.classpathFile get() = File(getSystemResource(this).file)
