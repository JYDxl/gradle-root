package org.github.controller

import cn.dev33.satoken.exception.SaTokenException
import org.github.exception.ExternalException
import org.github.exception.InternalException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = JSONReturn.internal(null).apply {log.error(e) {}}

  @ExceptionHandler(ExternalException::class)
  fun handleExternalException(e: ExternalException) = JSONReturn.external(e.message)

  @ExceptionHandler(InternalException::class)
  fun handleInternalException(e: InternalException) = JSONReturn.internal(e.message).apply {log.error(e) {}}

  @ExceptionHandler(SaTokenException::class)
  fun handleSaTokenException(e: SaTokenException) = ResponseEntity(e.message, UNAUTHORIZED)

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException) = JSONReturn.external(e.bindingResult.allErrors[0].defaultMessage)
}
