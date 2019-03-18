package org.github.spring.footstone

import org.github.ops.log
import org.github.ops.req
import java.io.Serializable

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
      val request = req!!
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
}
