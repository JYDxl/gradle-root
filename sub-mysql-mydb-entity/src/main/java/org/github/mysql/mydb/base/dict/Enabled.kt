package org.github.mysql.mydb.base.dict

import org.github.base.BaseEnum

enum class Enabled(override val code: String, override val value: String): BaseEnum {
    /** 禁用 */
  DISABLED("disabled","禁用"),
    /** 启用，默认值 */
  ENABLED("enabled","启用"),
}
