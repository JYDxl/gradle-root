package org.github.module.file.common.dto

import org.github.netty.ops.Mark

class User(private val username: String, private val password: String): Mark {
  override val id: String get() = username

  override fun toString(): String {
    return "username=$username, password=$password, "
  }
}
