package org.github.common.controller

import cn.dev33.satoken.exception.NotLoginException
import cn.dev33.satoken.exception.NotPermissionException
import cn.dev33.satoken.exception.NotRoleException
import cn.dev33.satoken.exception.NotSafeException
import javax.validation.ConstraintViolationException
import org.github.core.exception.ClientException
import org.github.core.exception.RemoteException
import org.github.core.exception.ServerException
import org.github.core.ops.error
import org.github.core.ops.log
import org.github.core.ops.warn
import org.github.core.spring.restful.json.JSONReturn.of
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.FORBIDDEN
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = of(INTERNAL_SERVER_ERROR, null).apply {log.error(e) {}}

  @ExceptionHandler(ClientException::class, HttpRequestMethodNotSupportedException::class)
  fun handleExternalException(e: Exception) = of(BAD_REQUEST, e.message).apply {log.warn {e.message}}

  @ExceptionHandler(ServerException::class)
  fun handleInternalException(e: ServerException) = of(INTERNAL_SERVER_ERROR, e.message).apply {log.warn {e.message}}

  @ExceptionHandler(RemoteException::class)
  fun handleRemoteException(e: RemoteException) = e.data

  @ExceptionHandler(NotLoginException::class)
  fun handleAuthException(e: Exception) = of(UNAUTHORIZED, e.message)

  @ExceptionHandler(NotPermissionException::class, NotRoleException::class, NotSafeException::class)
  fun handlePermException(e: Exception) = of(FORBIDDEN, e.message)

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException) = of(BAD_REQUEST, e.bindingResult.allErrors.map {it.defaultMessage}.joinToString("；"))

  @ExceptionHandler(ConstraintViolationException::class)
  fun handleConstraintViolationException(e: ConstraintViolationException) = of(BAD_REQUEST, e.constraintViolations.joinToString("；") {it.message})
}
