package org.github.ops

import com.google.common.io.BaseEncoding.*

val ByteArray.hexStr: String get() = base16().encode(this)
