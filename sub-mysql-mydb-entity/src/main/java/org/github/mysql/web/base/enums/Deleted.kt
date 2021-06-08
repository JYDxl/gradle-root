package org.github.mysql.web.base.enums

import org.github.base.IEnum

enum class Deleted(override val code: String, override val value: String): IEnum<String, String> {
  EXISTS("0", "未删除"),
  DELETED("1", "已删除");
}
