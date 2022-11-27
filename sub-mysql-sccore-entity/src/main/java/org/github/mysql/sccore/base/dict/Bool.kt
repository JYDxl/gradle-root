@file:Suppress("unused")

package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

/**
 * 是否 
 *
 * @author JYD_XL
 */
enum class Bool(override val code: String, override val value: String): BaseEnum {
  /** 否  */
  N("N","否"),
  /** 是  */
  Y("Y","是"),
  ;

  companion object {
    const val BOOL : String = "Bool"
  }
}
