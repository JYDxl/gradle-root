package org.github.mysql.mydb.base.dict

import org.github.base.BaseEnum

enum class Sex(override val code: String, override val value: String): BaseEnum {
    /** 保密，默认值 */
  SECRET("secret","保密"),
    /** 男 */
  MAN("man","男"),
    /** 女 */
  WOMAN("woman","女"),
}
