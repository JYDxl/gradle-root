package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

/**
 * 婚姻状况 婚姻状况的码表
 *
 * @author JYD_XL
 */
enum class Marital(override val code: String, override val value: String): BaseEnum {
  /** 离婚  */
  DIVORCE("divorce","离婚"),
  /** 已婚  */
  MARRIED("married","已婚"),
  /** 未知  */
  UNKNOWN("unknown","未知"),
  /** 未婚  */
  UNMARRIED("unmarried","未婚"),
  /** 丧偶  */
  WIDOWED("widowed","丧偶"),
}
