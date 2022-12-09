package org.github.core.spring.restful.ops

import org.springframework.http.HttpStatus.*

enum class Result(val code: Int, val msg: String) {
  SUCCESS(OK.value(), OK.reasonPhrase),
  SYSTEM_ERROR(INTERNAL_SERVER_ERROR.value(), "系统错误"),
  PARAMS_ERROR(BAD_REQUEST.value(), "参数错误"),
  AUTH_ERROR(UNAUTHORIZED.value(), "用户错误"),
  PERM_ERROR(FORBIDDEN.value(), "权限错误"),
  PATH_ERROR(NOT_FOUND.value(), "路径错误"),
  CALL_ERROR(SERVICE_UNAVAILABLE.value(), "调用错误")
}
