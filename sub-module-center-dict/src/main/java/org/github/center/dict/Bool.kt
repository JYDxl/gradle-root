@file:Suppress("unused")

package org.github.center.dict

import org.github.core.base.BaseEnum

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
    const val BOOL_DICT : String = "Bool"
  }
}
