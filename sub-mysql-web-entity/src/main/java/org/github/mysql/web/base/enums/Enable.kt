package org.github.mysql.web.base.enums

import org.github.base.IEnum

enum class Enable(override val code: Int, override val value: String): IEnum<Int, String> {
  DISABLED(0, "禁用"),
  ENABLED(1, "启用");
}
