package org.github.controller

import cn.hutool.core.lang.Validator.hasChinese
import org.apache.shiro.ShiroException
import org.github.exception.ParamsErrorException
import org.github.exception.RemoteErrorException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.json.JSONReturn.*
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {
  private val log = ErrorController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable): JSONReturn = error().apply {if (hasChinese(e.localizedMessage)) withRetMsg(e.localizedMessage)}.also {log.error(e) {}}

  @ExceptionHandler(ParamsErrorException::class)
  fun handleParamsErrorException(e: ParamsErrorException): JSONReturn = warn().withRetMsg(e.localizedMessage).also {log.error(e) {}}

  @ExceptionHandler(RemoteErrorException::class)
  fun handleRemoteErrorException(e: RemoteErrorException): JSONReturn = e.data.also {log.error(e) {}}

  @ExceptionHandler(ShiroException::class)
  fun handleShiroException(e: ShiroException): JSONReturn = auth().apply {withRetMsg(if (hasChinese(e.localizedMessage)) e.localizedMessage else "权限不足")}.also {log.error(e) {}}
}
