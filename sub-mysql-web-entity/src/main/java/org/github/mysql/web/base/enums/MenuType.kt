package org.github.mysql.web.base.enums

import org.github.base.IEnum

enum class MenuType(override val code: Int, override val value: String): IEnum<Int, String> {
  //类型   0：目录   1：菜单   2：按钮
  DIRECTORY(0, "目录"),
  MENU(1, "菜单"),
  BUTTON(2, "按钮");
}
