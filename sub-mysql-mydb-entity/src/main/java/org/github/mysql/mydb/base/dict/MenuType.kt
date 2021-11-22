package org.github.mysql.mydb.base.dict

import org.github.base.BaseEnum

enum class MenuType(override val code: String, override val value: String): BaseEnum {
    /** 目录 */
  DIRECTORY("directory","目录"),
    /** 菜单 */
  MENU("menu","菜单"),
    /** 按钮 */
  BUTTON("button","按钮"),
}
