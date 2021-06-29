package org.github.order.service

import org.github.order.dto.CreateOrderBO
import org.github.spring.restful.json.JSONDataReturn

interface IOrderService {
  fun createOrder(bo: CreateOrderBO): JSONDataReturn<Boolean>
}
