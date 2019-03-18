package org.github.spring.mvc

import org.github.ops.log
import org.github.ops.req
import org.github.ops.resp
import org.github.ops.trace
import org.github.ops.value
import org.github.spring.restful.Returnable
import org.springframework.core.MethodParameter
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.method.support.ModelAndViewContainer
import javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR

/**
 * Returnable返回类型解析器，Kotlin版.
 *
 * @author JYD_XL
 * @see HandlerMethodReturnValueHandler
 */
object ReturnableValueHandlerKotlin: HandlerMethodReturnValueHandler {
  override fun supportsReturnType(returnType: MethodParameter) = Returnable::class.java.isAssignableFrom(returnType.parameterType)

  override fun handleReturnValue(returnValue: Any?, returnType: MethodParameter, mavContainer: ModelAndViewContainer, webRequest: NativeWebRequest) {
    val result = (returnValue ?: Returnable.nil()) as Returnable
    val req = req!!
    val resp = resp!!
    if(result.isTerminated) {
      try {
        result.collect(req, resp)
      } catch(e: Exception) {
        log.error(e.message, e)
        resp.sendError(SC_INTERNAL_SERVER_ERROR)
      }
    } else {
      mavContainer.viewName = result.value
    }
    mavContainer.isRequestHandled = result.isTerminated
    result.apply { log.trace { "Writing [$contentType] TO $value" } }
  }
}
