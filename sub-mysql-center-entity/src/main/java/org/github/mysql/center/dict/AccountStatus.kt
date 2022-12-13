@file:Suppress("unused")

package org.github.mysql.center.dict

import org.github.core.base.BaseEnum

/**
 * 账号状态 
 *
 * @author JYD_XL
 */
enum class AccountStatus(override val code: String, override val value: String): BaseEnum {
  /** 启用  */
  ENABLED("ENABLED","启用"),
  /** 锁定  */
  LOCKED("LOCKED","锁定"),
  ;

  companion object {
    const val ACCOUNT_STATUS : String = "AccountStatus"
  }
}
