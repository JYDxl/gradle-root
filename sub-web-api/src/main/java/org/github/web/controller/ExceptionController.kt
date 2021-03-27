package org.github.web.controller

import org.github.exception.ParamsErrorException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.restful.json.JSONReturn.error
import org.github.spring.restful.json.JSONReturn.warn
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(ParamsErrorException::class)
  fun handleParamsErrorException(e: ParamsErrorException) = warn().withRetMsg(e.message.toString()).apply { log.error(e) { e.message } }

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = error().withRetMsg(e.message.toString()).apply { log.error(e) { e.message } }
}
