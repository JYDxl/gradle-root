package org.github.controller

import org.github.mysql.web.base.entity.PaymentEntity
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn
import org.github.web.module.sys.menu.service.IPayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/payment/")
@RestController
class PaymentController {
  @Autowired
  private lateinit var payService: IPayService

  @PostMapping("create")
  fun create(@RequestBody bo: PaymentEntity): Returnable = JSONDataReturn.of(payService.create(bo))

  @GetMapping("get/{id}")
  fun get(@PathVariable id: Long): Returnable = JSONDataReturn.of(payService.get(id))
}
