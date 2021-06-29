package org.github.storage

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.github.ops.trimStrFields
import org.github.storage.dto.DecreaseProductBO
import org.github.storage.service.IStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["库存管理"])
@RequestMapping("/storage/")
@RestController
class StorageController {
  @Autowired
  private lateinit var storageService: IStorageService

  @ApiOperation("减库存")
  @PostMapping("decreaseProduct")
  fun decreaseProduct(@RequestBody @Valid bo: DecreaseProductBO) = storageService.decreaseProduct(bo.trimStrFields())

  // @ApiOperation("更新订单状态")
  // @PostMapping("updateOrderStatus")
  // fun updateOrderStatus(@RequestBody bo: UpdateOrderStatusBO) = orderService.updateOrderStatus(bo.trimStrFields())
}
