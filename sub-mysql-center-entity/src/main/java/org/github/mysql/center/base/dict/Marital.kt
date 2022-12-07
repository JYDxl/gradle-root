@file:Suppress("unused")

package org.github.mysql.center.base.dict

import org.github.core.base.BaseEnum

/**
 * 婚姻状况 婚姻状况的码表
 *
 * @author JYD_XL
 */
enum class Marital(override val code: String, override val value: String): BaseEnum {
  /** 离婚  */
  DIVORCE("DIVORCE","离婚"),
  /** 已婚  */
  MARRIED("MARRIED","已婚"),
  /** 未知  */
  UNKNOWN("UNKNOWN","未知"),
  /** 未婚  */
  UNMARRIED("UNMARRIED","未婚"),
  /** 丧偶  */
  WIDOWED("WIDOWED","丧偶"),
  ;

  companion object {
    const val MARITAL : String = "Marital"
  }
}
