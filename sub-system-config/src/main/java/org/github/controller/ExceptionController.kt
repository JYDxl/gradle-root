package org.github.controller

import cn.hutool.core.lang.Validator.hasChinese
import feign.FeignException
import org.apache.shiro.ShiroException
import org.github.exception.ParamsErrorException
import org.github.exception.RemoteErrorException
import org.github.ops.error
import org.github.ops.log
import org.github.spring.ops.objectMapper
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.json.JSONReturn.*
import org.springframework.http.HttpStatus.resolve
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionController {
  private val log = ExceptionController::class.log

  @ExceptionHandler(Throwable::class)
  fun handleThrowable(e: Throwable) = error().apply {if (hasChinese(e.localizedMessage)) withRetMsg(e.localizedMessage)}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}

  @ExceptionHandler(ParamsErrorException::class)
  fun handleParamsErrorException(e: ParamsErrorException) = param().apply {if (hasChinese(e.localizedMessage)) withRetMsg(e.localizedMessage)}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}

  @ExceptionHandler(HttpMessageNotReadableException::class)
  fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException) = param().apply {withRetMsg("请求体缺失")}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}

  @ExceptionHandler(RemoteErrorException::class)
  fun handleRemoteErrorException(e: RemoteErrorException) = e.data.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}

  @ExceptionHandler(ShiroException::class)
  fun handleShiroException(e: ShiroException) = auth().apply {withRetMsg(if (hasChinese(e.localizedMessage)) e.localizedMessage else "权限不足")}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}

  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<JSONReturn> {
    val msg = e.bindingResult.fieldErrors.joinToString(separator = " && ") {"${it.field}${it.defaultMessage}"}
    return param().apply {withRetMsg(msg)}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}
  }

  @ExceptionHandler(ConstraintViolationException::class)
  fun handleConstraintViolationException(e: ConstraintViolationException): ResponseEntity<JSONReturn> {
    return param().apply {if (hasChinese(e.localizedMessage)) withRetMsg(e.localizedMessage)}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException::class)
  fun handleMethodArgumentTypeMismatchException(e: MethodArgumentTypeMismatchException): ResponseEntity<JSONReturn> {
    return param().apply {withRetMsg("${e.name}: 参数类型不匹配")}.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}
  }

  @ExceptionHandler(FeignException::class)
  fun handleFeignException(e: FeignException): ResponseEntity<JSONReturn> {
    val data = objectMapper.readValue(e.contentUTF8(), JSONReturn::class.java)!!
    return data.let {ResponseEntity(it, resolve(it.status)!!)}.also {log.error(e) {}}
  }
}
