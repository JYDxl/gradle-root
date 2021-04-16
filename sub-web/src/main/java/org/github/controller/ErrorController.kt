package org.github.controller

import org.github.exception.ParamsErrorException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn.error
import org.github.spring.restful.json.JSONReturn.warn
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {
  private val log = ErrorController::class.log

  @ExceptionHandler(Throwable::class)
  fun throwableHandler(e: Throwable) = error().withRetMsg(e.localizedMessage).also {log.error(e) {}}

  @ExceptionHandler(ParamsErrorException::class)
  fun paramsErrorHandler(e: ParamsErrorException) = warn().withRetMsg(e.localizedMessage).also {log.error(e) {}}
}