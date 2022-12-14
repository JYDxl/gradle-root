package org.github.gateway.dto

import org.springframework.http.HttpStatus

class Result(status: HttpStatus, reason: String? = null) {
    private val code: Int

    private val msg: String

    init {
        code = status.value()
        msg = reason ?: status.name
    }
}
