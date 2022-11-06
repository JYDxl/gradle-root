package org.github.mysql.sccore.base.dict

import org.github.base.BaseEnum

enum class MenuType(override val code: Int, override val value: String): BaseEnum {
  /** 目录 */
  DIRECTORY(0, "目录"),

  /** 菜单 */
  MENU(1, "菜单"),

  /** 按钮 */
  BUTTON(2, "按钮"),
}
