package org.github.module.file.common

import org.github.netty.ops.Mark

data class User(private val username: String, private val password: String, private val cid: String): Mark {
  override val id: String get() = username
}
