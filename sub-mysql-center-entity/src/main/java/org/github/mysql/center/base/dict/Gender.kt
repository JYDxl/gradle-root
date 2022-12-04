@file:Suppress("unused")

package org.github.mysql.center.base.dict

import org.github.base.BaseEnum

/**
 * 性别 
 *
 * @author JYD_XL
 */
enum class Gender(override val code: String, override val value: String): BaseEnum {
  /** 男  */
  MAN("MAN","男"),
  /** 未知  */
  UNKNOWN("UNKNOWN","未知"),
  /** 女  */
  WOMEN("WOMEN","女"),
  ;

  companion object {
    const val GENDER : String = "Gender"
  }
}
