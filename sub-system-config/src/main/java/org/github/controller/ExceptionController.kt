package org.github.controller

import org.github.exception.ClientException
import org.github.ops.error
import org.github.ops.log
import org.springframework.http.ResponseEntity.badRequest
import org.springframework.http.ResponseEntity.internalServerError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = internalServerError().apply {log.error(e) {}}

  @ExceptionHandler(ClientException::class, ConstraintViolationException::class)
  fun handleParamsErrorException(e: Exception) = badRequest().apply {log.error(e) {}}
}
