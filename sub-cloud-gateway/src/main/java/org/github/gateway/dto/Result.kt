package org.github.gateway.dto

import org.springframework.http.HttpStatus

@Suppress("MemberVisibilityCanBePrivate")
class Result(status: HttpStatus, reason: String? = null) {
  val code: Int

  val msg: String

  init {
    code = status.value()
    msg = reason ?: status.name
  }
}
