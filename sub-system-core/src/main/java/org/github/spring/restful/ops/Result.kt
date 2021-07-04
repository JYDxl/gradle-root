package org.github.spring.restful.ops

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

enum class Result(val code: Int, val msg: String, val status: HttpStatus) {
  SUCCESS(OK.value(), OK.reasonPhrase, OK),
  SYSTEM_ERROR(INTERNAL_SERVER_ERROR.value(), "系统错误", INTERNAL_SERVER_ERROR),
  PARAMS_ERROR(BAD_REQUEST.value(), "参数错误", OK),
  PATH_ERROR(NOT_FOUND.value(), "路径错误", OK),
  AUTH_ERROR(UNAUTHORIZED.value(), "权限错误", OK)
}
