package org.github.mysql.mydb.base.dict

import org.github.base.BaseEnum

enum class Deleted(override val code: String, override val value: String): BaseEnum {
    /** 未删除，默认值 */
  EXISTS("exists","未删除"),
    /** 已删除 */
  DELETED("deleted","已删除"),
}
