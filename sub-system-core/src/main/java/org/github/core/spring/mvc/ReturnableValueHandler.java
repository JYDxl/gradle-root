package org.github.core.spring.mvc;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import lombok.extern.slf4j.*;
import org.github.core.spring.restful.Returnable;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import static java.util.Objects.*;
import static javax.servlet.http.HttpServletResponse.*;
import static org.github.core.spring.restful.Returnable.*;

/**
 * Returnable返回类型解析器 Java版
 *
 * @author JYD_XL
 * @see org.springframework.web.method.support.HandlerMethodReturnValueHandler
 */
@Slf4j
public class ReturnableValueHandler implements HandlerMethodReturnValueHandler {
  @Override
  public boolean supportsReturnType(@NonNull MethodParameter returnType) {
    return Returnable.class.isAssignableFrom(returnType.getParameterType());
  }

  @Override
  public void handleReturnValue(@Nullable Object returnValue, @NonNull MethodParameter returnType, @NonNull ModelAndViewContainer mavContainer, @NonNull NativeWebRequest webRequest) throws IOException {
    val value = returnValue == null ? nil() : ((Returnable) returnValue);
    val req   = requireNonNull(webRequest.getNativeRequest(HttpServletRequest.class));
    val resp  = requireNonNull(webRequest.getNativeResponse(HttpServletResponse.class));
    if (value.terminated()) {
      try {
        value.handle(req, resp);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
        resp.sendError(SC_INTERNAL_SERVER_ERROR);
      }
    } else {
      mavContainer.setViewName(requireNonNull(value.get()));
    }
    mavContainer.setRequestHandled(value.terminated());
    log.trace("Writing [{}] ====> {}", value.mediaType(), value.get());
  }
}