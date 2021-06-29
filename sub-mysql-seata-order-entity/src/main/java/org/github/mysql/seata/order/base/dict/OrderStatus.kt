package org.github.mysql.seata.order.base.dict

import org.github.base.IEnum

enum class OrderStatus(override val code: Int, override val value: String): IEnum<Int, String> {
  //订单状态 0：创建中 1：已结束
  CREATE(0, "创建中"),
  END(1, "已结束");
}
