package org.github.controller

import cn.dev33.satoken.exception.*
import org.github.exception.ExternalException
import org.github.exception.InternalException
import org.github.exception.RemoteException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = JSONReturn.internal(null).apply {log.error(e) {}}

  @ExceptionHandler(ExternalException::class)
  fun handleExternalException(e: ExternalException) = JSONReturn.external(e.message)

  @ExceptionHandler(InternalException::class)
  fun handleInternalException(e: InternalException) = JSONReturn.internal(e.message)

  @ExceptionHandler(RemoteException::class)
  fun handleRemoteException(e: RemoteException) = e.data

  @ExceptionHandler(SaTokenException::class)
  fun handleSaTokenException(e: SaTokenException) = ResponseEntity(e.message, UNAUTHORIZED)

  @ExceptionHandler(NotLoginException::class)
  fun handleAuthException(e: Exception) = JSONReturn.auth(e.message)

  @ExceptionHandler(NotPermissionException::class, NotRoleException::class, NotSafeException::class)
  fun handlePermException(e: Exception) = JSONReturn.perm(e.message)

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException) = JSONReturn.external(e.bindingResult.allErrors.map {it.defaultMessage}.joinToString("；"))

  @ExceptionHandler(ConstraintViolationException::class)
  fun handleConstraintViolationException(e: ConstraintViolationException) = JSONReturn.external(e.constraintViolations.joinToString("；") {it.message})
}
