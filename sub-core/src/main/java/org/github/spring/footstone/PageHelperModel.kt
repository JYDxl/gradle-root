package org.github.spring.footstone

import org.apache.ibatis.session.RowBounds
import java.lang.Boolean.parseBoolean
import java.lang.Integer.parseInt
import java.util.Optional

/**
 * 分页查询数据模型,该类的作用是辅助分页及帮助分页时进行排序操作.
 *
 * @author JYD_XL
 * @see org.github.spring.footstone.AbstractEntity
 */
class PageHelperModel : AbstractEntity() {
  var sortName: String = ""
    set(sortName) = Optional.ofNullable(sortName).filter { v -> PARAM_PATTERN.matcher(v).matches() }.ifPresent { v -> field = v }

  /** sort order.  */
  /** GET sortOrder.  */
  /** SET sortOrder.  */
  var sortOrder = ASC
    set(sortOrder) {
      if (ASC.equals(sortOrder, ignoreCase = true) || "DESC".equals(sortOrder, ignoreCase = true)) field = sortOrder.toUpperCase()
    }

  /** page number.  */
  /** GET pageNumber.  */
  /** SET pageNumber.  */
  var pageNumber = NUMBER

  /** page flag.  */
  /** GET method.  */
  /** SET method.  */
  var pageFlag = FLAG

  /** page size.  */
  /** GET pageSize.  */
  /** SET pageSize.  */
  var pageSize = SIZE

  /** calculate page size,part or full.  */
  private fun calculate(): Int {
    return if (pageFlag) pageSize else 0
  }

  /** Get RowBounds.  */
  @Deprecated("")
  fun createRowBounds(): RowBounds {
    return RowBounds(pageNumber, this.calculate())
  }

  /**
   * 获取排序信息,使用手写SQL时使用.
   *
   * @return 排序信息
   */
  private fun createSortInfoByCustom(): String? {
    return Optional.ofNullable(this.sortName).filter({ it.isNotBlank() }).map { v -> v + SPACE + this.sortOrder }.orElse(null)
  }

  /**
   * 获取排序信息,将驼峰命名转为下划线命名,使用自动生成查询语句时使用.
   *
   * @return 排序信息
   */
  private fun createSortInfoByDefault(): String? {
    if (sortName.isBlank()) return null
    val column = StringBuilder()
    for (i in 0 until this.sortName.length) {
      if (Character.isUpperCase(this.sortName[i])) {
        column.append(UNDER_LINE).append(Character.toLowerCase(this.sortName[i]))
      } else {
        column.append(this.sortName[i])
      }
    }
    return column.append(SPACE).append(this.sortOrder).toString()
  }

  /** SET method.  */
  fun setPageFlag(flag: String?) {
    if (flag.isNullOrBlank()) return
    pageFlag = parseBoolean(flag)
  }

  /** SET pageNumber.  */
  fun setPageNumber(number: String?) {
    if (number.isNullOrBlank()) return
    pageNumber = parseInt(number)
  }

  /** SET pageSize.  */
  fun setPageSize(size: String?) {
    if (size.isNullOrBlank()) return
    pageSize = parseInt(size)
  }

  /** WITH sortName.  */
  fun withColumn(column: String): PageHelperModel {
    this.sortName = column
    return this
  }

  /** WITH method.  */
  fun withFlag(flag: Boolean): PageHelperModel {
    this.pageFlag = flag
    return this
  }

  /** WITH pageNumber.  */
  fun withNumber(number: Int): PageHelperModel {
    this.pageNumber = number
    return this
  }

  /** WITH sortOrder.  */
  fun withOrder(order: String): PageHelperModel {
    this.sortOrder = order
    return this
  }

  /** WITH pageSize.  */
  fun withSize(size: Int): PageHelperModel {
    this.pageSize = size
    return this
  }
}
