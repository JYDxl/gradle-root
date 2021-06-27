package org.github.order.service

import org.github.order.dto.CreateOrderBO
import org.github.order.dto.UpdateOrderStatusBO
import org.github.spring.restful.json.JSONDataReturn

interface IOrderService {
  fun createOrder(bo: CreateOrderBO): JSONDataReturn<Boolean>

  fun updateOrderStatus(bo: UpdateOrderStatusBO): JSONDataReturn<Boolean>
}
