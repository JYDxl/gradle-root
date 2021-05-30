package org.github.mysql.web.base.enums

import org.github.base.IEnum

enum class Sex(override val code: Int, override val value: String): IEnum<Int, String> {
  MAN(0, "男"),
  WOMAN(1, "女");
}
