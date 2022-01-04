package org.github.module.file.common

import org.github.netty.ops.Mark

data class Device(private val name: String, private val cid: String): Mark {
  override val id: String get() = name
}
