package org.github.mysql.web.base.dict

import org.github.base.IEnum

enum class MenuType(override val code: Int, override val value: String): IEnum<Int, String> {
  //类型   1：目录   2：菜单   3：按钮
  DIRECTORY(1, "目录"),
  MENU(2, "菜单"),
  BUTTON(3, "按钮");
}
