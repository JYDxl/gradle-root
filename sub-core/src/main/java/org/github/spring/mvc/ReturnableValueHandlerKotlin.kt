package org.github.spring.mvc

import org.github.ops.error
import org.github.ops.log
import org.github.ops.trace
import org.github.spring.restful.Returnable
import org.github.spring.restful.Returnable.nil
import org.springframework.core.MethodParameter
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.method.support.ModelAndViewContainer
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR

/**
 * Returnable返回类型解析器，Kotlin版.
 *
 * @author JYD_XL
 * @see HandlerMethodReturnValueHandler
 */
object ReturnableValueHandlerKotlin: HandlerMethodReturnValueHandler {
  private val log = ReturnableValueHandlerKotlin::class.log

  override fun supportsReturnType(returnType: MethodParameter) = Returnable::class.java.isAssignableFrom(returnType.parameterType)

  override fun handleReturnValue(returnValue: Any?, returnType: MethodParameter, mavContainer: ModelAndViewContainer, webRequest: NativeWebRequest) {
    val value = (returnValue ?: nil()) as Returnable
    val req = requireNotNull(webRequest.getNativeRequest(HttpServletRequest::class.java))
    val res = requireNotNull(webRequest.getNativeResponse(HttpServletResponse::class.java))
    if (value.terminated()) {
      try {
        value.collect(req, res)
      } catch (e: Exception) {
        log.error(e) {}
        res.sendError(SC_INTERNAL_SERVER_ERROR)
      }
    } else {
      mavContainer.viewName = value.get()
    }
    mavContainer.isRequestHandled = value.terminated()
    value.apply {log.trace {"Writing [${mediaType()}] ====> ${get()}"}}
  }
}
