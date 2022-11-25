package org.github.center.controller

import cn.dev33.satoken.exception.*
import com.google.common.net.HttpHeaders.CONTENT_TYPE
import org.github.exception.ExternalException
import org.github.exception.InternalException
import org.github.exception.RemoteException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.json.JSONReturn.*
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = internal(null).apply {log.error(e) {}}.entity

  @ExceptionHandler(ExternalException::class, HttpRequestMethodNotSupportedException::class)
  fun handleExternalException(e: Exception) = external(e.message).entity

  @ExceptionHandler(InternalException::class)
  fun handleInternalException(e: InternalException) = internal(e.message).entity

  @ExceptionHandler(RemoteException::class)
  fun handleRemoteException(e: RemoteException) = e.data.entity

  @ExceptionHandler(NotLoginException::class)
  fun handleAuthException(e: Exception) = auth(e.message).entity

  @ExceptionHandler(NotPermissionException::class, NotRoleException::class, NotSafeException::class)
  fun handlePermException(e: Exception) = perm(e.message).entity

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException) = external(e.bindingResult.allErrors.map {it.defaultMessage}.joinToString("；")).entity

  @ExceptionHandler(ConstraintViolationException::class)
  fun handleConstraintViolationException(e: ConstraintViolationException) = external(e.constraintViolations.joinToString("；") {it.message}).entity

  private val JSONReturn.entity: HttpEntity<String> get() = ok().header(CONTENT_TYPE, mediaType().toString()).body(toString())
}
