package org.github.controller

import org.apache.shiro.ShiroException
import org.github.exception.ParamsErrorException
import org.github.ops.error
import org.github.ops.log
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = internalServerError().apply {log.error(e) {}}

  @ExceptionHandler(ParamsErrorException::class, ConstraintViolationException::class)
  fun handleParamsErrorException(e: Exception) = badRequest().apply {log.error(e) {}}

  @ExceptionHandler(ShiroException::class)
  fun handleShiroException(e: ShiroException) = status(UNAUTHORIZED).apply {log.error(e) {}}
}
