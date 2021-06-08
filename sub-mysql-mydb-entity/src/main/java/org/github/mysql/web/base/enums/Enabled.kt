package org.github.mysql.web.base.enums

import org.github.base.IEnum

enum class Enabled(override val code: String, override val value: String): IEnum<String, String> {
  DISABLED("0", "禁用"),
  ENABLED("1", "启用");
}
