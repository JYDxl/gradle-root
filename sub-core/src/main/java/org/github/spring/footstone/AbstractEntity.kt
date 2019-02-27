package org.github.spring.footstone

import org.slf4j.LoggerFactory.getLogger
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.Serializable
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 抽象实体类, 不允许存在状态.
 *
 * @author JYD_XL
 */
abstract class AbstractEntity: Serializable {
  /** 参数断言.  */
  fun assertj(): AbstractEntity = this

  /** 参数注入.  */
  fun migrate(): AbstractEntity = this

  /** 创建 page辅助数据模型.  */
  fun newPageHelper(): PageHelperModel {
    val model = PageHelperModel()
    try {
      val request = request()!!
      model.setPageSize(request.getParameter(PAGE_SIZE))
      model.setPageFlag(request.getParameter(PAGE_FLAG))
      model.setPageNumber(request.getParameter(PAGE_NUMBER))
      model.sortName = request.getParameter(SORT_NAME)
      model.sortOrder = request.getParameter(SORT_ORDER)
    } catch(e: Exception) {
      log.error(e.message, e)
    }
    return model
  }

  /** 获取 请求对象.  */
  fun request(): HttpServletRequest? {
    val servletRequestAttributes = getRequestAttributes() as? ServletRequestAttributes
    return servletRequestAttributes?.request
  }

  /** 获取 响应对象.  */
  fun response(): HttpServletResponse? {
    val servletRequestAttributes = getRequestAttributes() as? ServletRequestAttributes
    return servletRequestAttributes?.response
  }

  companion object {
    /** log. */
    val log = getLogger(AbstractEntity::class.java)!!
  }
}
