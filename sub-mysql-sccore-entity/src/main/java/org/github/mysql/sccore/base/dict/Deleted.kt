package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

enum class Deleted(override val code: Int, override val value: String): BaseEnum {
  /** 未删除，默认值 */
  EXISTS(0, "未删除"),

  /** 已删除 */
  DELETED(1, "已删除"),
}
