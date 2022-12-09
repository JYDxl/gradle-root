package org.github.common.controller

import cn.dev33.satoken.exception.*
import org.github.core.exception.ExternalException
import org.github.core.exception.InternalException
import org.github.core.exception.RemoteException
import org.github.core.ops.error
import org.github.core.ops.log
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
  fun handleThrowable(e: Throwable): HttpEntity<String> {
    return internal(null).status().apply {log.error(e) {}}
  }

  @ExceptionHandler(ExternalException::class, HttpRequestMethodNotSupportedException::class)
  fun handleExternalException(e: Exception): HttpEntity<String> {
    return external(e.message).status()
  }

  @ExceptionHandler(InternalException::class)
  fun handleInternalException(e: InternalException): HttpEntity<String> {
    return internal(e.message).status()
  }

  @ExceptionHandler(RemoteException::class)
  fun handleRemoteException(e: RemoteException): HttpEntity<String> {
    return e.data.status()
  }

  @ExceptionHandler(NotLoginException::class)
  fun handleAuthException(e: Exception): HttpEntity<String> {
    return auth(e.message).status()
  }

  @ExceptionHandler(NotPermissionException::class, NotRoleException::class, NotSafeException::class)
  fun handlePermException(e: Exception): HttpEntity<String> {
    return perm(e.message).status()
  }

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): HttpEntity<String> {
    return external(e.bindingResult.allErrors.map {it.defaultMessage}.joinToString("；")).status()
  }

  @ExceptionHandler(ConstraintViolationException::class)
  fun handleConstraintViolationException(e: ConstraintViolationException): HttpEntity<String> {
    return external(e.constraintViolations.joinToString("；") {it.message}).status()
  }
}
