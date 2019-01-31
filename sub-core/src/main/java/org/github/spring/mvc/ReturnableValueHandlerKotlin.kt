package org.github.spring.mvc

import org.github.spring.restful.Returnable
import org.springframework.core.MethodParameter
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.method.support.ModelAndViewContainer
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Returnable返回类型解析器，Kotlin版.
 *
 * @author JYD_XL
 * @see HandlerMethodReturnValueHandler
 */
object ReturnableValueHandlerKotlin : HandlerMethodReturnValueHandler {
  override fun supportsReturnType(returnType: MethodParameter) = Returnable::class.java.isAssignableFrom(returnType.nestedParameterType)

  //TODO JYD_XL test
  override fun handleReturnValue(value: Any?, returnType: MethodParameter, mavContainer: ModelAndViewContainer, webRequest: NativeWebRequest) {
    value as Returnable
    val req = webRequest.getNativeRequest(HttpServletRequest::class.java)!!
    val resp = webRequest.getNativeResponse(HttpServletResponse::class.java)!!
    if(value.terminal()) {
      value.collect(req, resp)
    } else {
      mavContainer.viewName = value.get()
    }
    mavContainer.isRequestHandled = value.terminal()
  }
}
