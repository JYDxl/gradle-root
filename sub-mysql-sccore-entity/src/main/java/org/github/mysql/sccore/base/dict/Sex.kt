package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

enum class Sex(override val code: Int, override val value: String): BaseEnum {
  /** 保密，默认值 */
  SECRET(0, "保密"),

  /** 男 */
  MAN(1, "男"),

  /** 女 */
  WOMAN(2, "女"),
}
