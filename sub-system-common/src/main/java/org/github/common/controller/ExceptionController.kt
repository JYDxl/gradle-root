package org.github.common.controller

import cn.dev33.satoken.exception.*
import org.github.core.exception.ClientException
import org.github.core.exception.RemoteException
import org.github.core.exception.ServerException
import org.github.core.ops.error
import org.github.core.ops.log
import org.github.core.ops.warn
import org.github.core.spring.restful.json.JSONReturn.*
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus.*
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable): HttpEntity<String> = of(INTERNAL_SERVER_ERROR, null).http().apply {log.error(e) {}}

  @ExceptionHandler(ClientException::class, HttpRequestMethodNotSupportedException::class)
  fun handleExternalException(e: Exception): HttpEntity<String> = of(BAD_REQUEST, e.message).http().apply {log.warn {e.message}}

  @ExceptionHandler(ServerException::class)
  fun handleInternalException(e: ServerException): HttpEntity<String> = of(INTERNAL_SERVER_ERROR, e.message).http().apply {log.warn {e.message}}

  @ExceptionHandler(RemoteException::class)
  fun handleRemoteException(e: RemoteException): HttpEntity<String> = e.data.http()

  @ExceptionHandler(NotLoginException::class)
  fun handleAuthException(e: Exception): HttpEntity<String> = of(UNAUTHORIZED, e.message).http()

  @ExceptionHandler(NotPermissionException::class, NotRoleException::class, NotSafeException::class)
  fun handlePermException(e: Exception): HttpEntity<String> = of(FORBIDDEN, e.message).http()

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): HttpEntity<String> = of(BAD_REQUEST, e.bindingResult.allErrors.map {it.defaultMessage}.joinToString("；")).http()

  @ExceptionHandler(ConstraintViolationException::class)
  fun handleConstraintViolationException(e: ConstraintViolationException): HttpEntity<String> = of(BAD_REQUEST, e.constraintViolations.joinToString("；") {it.message}).http()
}
