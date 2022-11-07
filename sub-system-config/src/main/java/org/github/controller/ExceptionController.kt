package org.github.controller

import cn.dev33.satoken.exception.SaTokenException
import org.github.exception.ClientException
import org.github.exception.ServerException
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
  fun handleThrowable(e: Throwable) = JSONReturn.error(null).apply {log.error(e) {}}

  @ExceptionHandler(ClientException::class)
  fun handleClientException(e: ClientException) = JSONReturn.param(e.message).apply {log.error(e) {}}

  @ExceptionHandler(ServerException::class)
  fun handleServerException(e: ServerException) = JSONReturn.error(e.message).apply {log.error(e) {}}

  @ExceptionHandler(SaTokenException::class)
  fun handleNotLoginException(e: SaTokenException) = ResponseEntity(e.message, UNAUTHORIZED).apply {log.error(e) {}}

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException) = JSONReturn.param(e.bindingResult.allErrors[0].defaultMessage).apply {log.error(e) {}}
}
