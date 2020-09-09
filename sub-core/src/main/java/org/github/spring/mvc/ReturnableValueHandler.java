package org.github.spring.mvc;

import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.spring.restful.Returnable;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import static java.util.Objects.*;

/**
 * Returnable返回类型解析器，Java版.
 *
 * @author JYD_XL
 * @see org.springframework.web.method.support.HandlerMethodReturnValueHandler
 */
@Slf4j
public class ReturnableValueHandler implements HandlerMethodReturnValueHandler {
  @Override
  public boolean supportsReturnType(@Nonnull MethodParameter returnType) {
    return Returnable.class.isAssignableFrom(returnType.getParameterType());
  }

  @Override
  public void handleReturnValue(@Nullable Object returnValue, @Nonnull MethodParameter returnType, @Nonnull ModelAndViewContainer mavContainer, @Nonnull NativeWebRequest webRequest) throws IOException {
    val value = returnValue == null ? Returnable.nil() : ((Returnable) returnValue);
    val req   = requireNonNull(webRequest.getNativeRequest(HttpServletRequest.class));
    val resp  = requireNonNull(webRequest.getNativeResponse(HttpServletResponse.class));
    if(value.terminated()) {
      try {
        value.collect(req, resp);
      } catch(Exception e) {
        log.error(e.getMessage(), e);
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
    } else {
      mavContainer.setViewName(requireNonNull(value.get()));
    }
    mavContainer.setRequestHandled(value.terminated());
    log.trace("Writing [{}] TO {}", value.mediaType(), value.get());
  }
}
