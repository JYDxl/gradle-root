package org.github.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.github.ops.LoggerOpsKt;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONReturn;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionController {
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseBody
  public Returnable illegalArgumentExceptionHandler(Exception ex) {
    LoggerOpsKt.error(log, ex, ex::getMessage);
    return JSONReturn.error().withRetMsg(ex.getMessage());
  }
}
