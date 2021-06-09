package org.github.mysql.mydb.base.dict

import org.github.base.IEnum

enum class Sex(override val code: Int, override val value: String): IEnum<Int, String> {
  SECRET(0, "保密"),
  MAN(1, "男"),
  WOMAN(2, "女");
}
