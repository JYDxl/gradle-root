package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

/**
 * 性别 
 *
 * @author JYD_XL
 */
enum class Gender(override val code: String, override val value: String): BaseEnum {
  /** 男  */
  MAN("man","男"),
  /** 未知  */
  UNKNOWN("unknown","未知"),
  /** 女  */
  WOMEN("women","女"),
}
