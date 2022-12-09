package org.github.common.controller;

import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.*;
import lombok.extern.slf4j.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.dev33.satoken.exception.NotLoginException;
import static cn.hutool.core.text.CharSequenceUtil.*;
import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;
import static org.springframework.http.HttpStatus.*;

@Controller
@Getter
@Slf4j
@RequestMapping("/error")
public class ErrorController extends AbstractErrorController {
  private final ErrorProperties errorProperties;

  @Autowired
  public ErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
    super(errorAttributes);
    this.errorProperties = serverProperties.getError();
  }

  @RequestMapping
  public HttpEntity<String> error(HttpServletRequest request) {
    Map<String,Object> body  = getErrorAttributes(request, getErrorAttributeOptions(request));
    Object             trace = body.get("trace");
    if (trace != null) {
      return ex(trace);
    } else {
      return ResponseEntity.status(getStatus(request)).build();
    }
  }

  protected ErrorAttributeOptions getErrorAttributeOptions(HttpServletRequest request) {
    ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
    if (this.errorProperties.isIncludeException()) {
      options = options.including(EXCEPTION);
    }
    if (isIncludeStackTrace(request)) {
      options = options.including(STACK_TRACE);
    }
    if (isIncludeMessage(request)) {
      options = options.including(MESSAGE);
    }
    if (isIncludeBindingErrors(request)) {
      options = options.including(BINDING_ERRORS);
    }
    return options;
  }

  @NotNull
  private ResponseEntity<String> ex(Object trace) {
    String info = trace.toString().lines().findFirst().orElse("");
    if (isNotBlank(info)) {
      String ex = info.split(":", 2)[0];
      if (Objects.equals(NotLoginException.class.getName(), ex)) {
        return ResponseEntity.status(UNAUTHORIZED).build();
      }
    }
    return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
  }

  protected boolean isIncludeStackTrace(HttpServletRequest request) {
    return switch (getErrorProperties().getIncludeStacktrace()) {
      case ALWAYS -> true;
      case ON_PARAM -> getTraceParameter(request);
      default -> false;
    };
  }

  protected boolean isIncludeMessage(HttpServletRequest request) {
    return switch (getErrorProperties().getIncludeMessage()) {
      case ALWAYS -> true;
      case ON_PARAM -> getMessageParameter(request);
      default -> false;
    };
  }

  protected boolean isIncludeBindingErrors(HttpServletRequest request) {
    return switch (getErrorProperties().getIncludeBindingErrors()) {
      case ALWAYS -> true;
      case ON_PARAM -> getErrorsParameter(request);
      default -> false;
    };
  }
}
