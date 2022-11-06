package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

enum class Enabled(override val code: Int, override val value: String): BaseEnum {
  /** 禁用 */
  DISABLED(0, "禁用"),

  /** 启用，默认值 */
  ENABLED(1, "启用"),
}
