package org.github.system

import org.github.ops.error
import org.github.ops.log
import org.github.ops.spring.req
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView

//@ControllerAdvice
class ControllerExceptionHandler {
  private val log = ControllerExceptionHandler::class.log

  @ExceptionHandler(Exception::class)
  fun exceptionHandler(e: Exception): ModelAndView {
    log.error(e) { "检测到后台发生异常: ${e.message}" }
    return ModelAndView().apply {
      addObject("url", req?.requestURI)
      addObject("ex", e)
      viewName = "error/error"
    }
  }
}
