package org.github.order.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.github.ops.trimStrFields
import org.github.order.dto.CreateOrderBO
import org.github.order.service.IOrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["订单管理"])
@RequestMapping("/order/")
@RestController
class OrderController {
  @Autowired
  private lateinit var orderService: IOrderService

  @ApiOperation("创建订单")
  @PostMapping("createOrder")
  fun createOrder(@RequestBody @Valid bo: CreateOrderBO) = orderService.createOrder(bo.trimStrFields())

  // @ApiOperation("更新订单状态")
  // @PostMapping("updateOrderStatus")
  // fun updateOrderStatus(@RequestBody bo: UpdateOrderStatusBO) = orderService.updateOrderStatus(bo.trimStrFields())
}
