package org.github.mysql.web.base.dict

import org.github.base.IEnum

enum class Enabled(override val code: Int, override val value: String): IEnum<Int, String> {
  DISABLED(0, "禁用"),
  ENABLED(1, "启用");
}
