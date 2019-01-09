package org.github.spring.mvc;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.spring.restful.Returnable;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import static java.util.Objects.requireNonNull;
import static org.github.spring.restful.Returnable.of;

/**
 * Returnable返回类型解析器，Java版.
 *
 * @author JYD_XL
 * @see HandlerMethodReturnValueHandler
 */
@Slf4j
public class ReturnableValueHandler implements HandlerMethodReturnValueHandler {
  @Override
  public boolean supportsReturnType(@Nonnull MethodParameter returnType) {
    return Returnable.class.isAssignableFrom(returnType.getParameterType());
  }

  @SuppressWarnings("deprecation")
  @Override
  public void handleReturnValue(Object returnValue, @Nonnull MethodParameter returnType, @Nonnull ModelAndViewContainer mavContainer, @Nonnull NativeWebRequest webRequest) throws Exception {
    val value = ((Returnable) (returnValue == null ? of() : returnValue));
    val req   = webRequest.getNativeRequest(HttpServletRequest.class);
    val resp  = webRequest.getNativeResponse(HttpServletResponse.class);
    requireNonNull(req);
    requireNonNull(resp);
    if (value.terminal()) {
      value.collect(req, resp);
    } else {
      mavContainer.setViewName(value.get());
    }
    mavContainer.setRequestHandled(value.terminal());
  }
}
