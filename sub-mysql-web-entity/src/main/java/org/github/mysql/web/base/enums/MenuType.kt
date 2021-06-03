package org.github.mysql.web.base.enums

import org.github.base.IEnum

enum class MenuType(override val code: String, override val value: String): IEnum<String, String> {
  //类型   0：目录   1：菜单   2：按钮
  DIRECTORY("0", "目录"),
  MENU("1", "菜单"),
  BUTTON("2", "按钮");
}
