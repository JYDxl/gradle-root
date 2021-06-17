package org.github.controller

import org.apache.shiro.ShiroException
import org.github.exception.ParamsErrorException
import org.github.exception.RemoteErrorException
import org.github.ops.error
import org.github.ops.hasChinese
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn.*
import org.springframework.http.HttpStatus.resolve
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {
  private val log = ErrorController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = error().apply {if (e.localizedMessage.hasChinese()) withRetMsg(e.localizedMessage)}.let {ResponseEntity(it, requireNotNull(resolve(it.retCode)))}.also {log.error(e) {}}

  @ExceptionHandler(ParamsErrorException::class)
  fun handleParamsErrorException(e: ParamsErrorException) = warn().withRetMsg(e.localizedMessage).let {ResponseEntity(it, requireNotNull(resolve(it.retCode)))}.also {log.error(e) {}}

  @ExceptionHandler(RemoteErrorException::class)
  fun handleRemoteErrorException(e: RemoteErrorException) = e.data.let {ResponseEntity(it, requireNotNull(resolve(it.retCode)))}.also {log.error(e) {}}

  @ExceptionHandler(ShiroException::class)
  fun handleShiroException(e: ShiroException) = auth().apply {withRetMsg(if (e.localizedMessage.hasChinese()) e.localizedMessage else "权限不足")}.let {ResponseEntity(it, requireNotNull(resolve(it.retCode)))}.also {log.error(e) {}}
}
