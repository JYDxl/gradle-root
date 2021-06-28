package org.github.order.service.impl

import org.github.account.dto.DecreaseAccountBO
import org.github.account.feign.IServiceProviderAccountServer
import org.github.mybatis.ops.ktUpdateWrapper
import org.github.mysql.seata.order.base.entity.TOrderEntity
import org.github.mysql.seata.order.base.service.ITOrderService
import org.github.order.dto.CreateOrderBO
import org.github.order.dto.UpdateOrderStatusBO
import org.github.order.service.IOrderService
import org.github.service.ISystemService
import org.github.spring.restful.json.JSONDataReturn
import org.github.storage.dto.DecreaseProductBO
import org.github.storage.feign.IServiceProviderStorageServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl: IOrderService {
  @Autowired
  private lateinit var orderMbpService: ITOrderService

  @Autowired
  private lateinit var storageServer: IServiceProviderStorageServer

  @Autowired
  private lateinit var accountServer: IServiceProviderAccountServer

  @Autowired
  private lateinit var systemService: ISystemService

  // @GlobalTransactional(rollbackFor = [Exception::class])
  override fun createOrder(bo: CreateOrderBO): JSONDataReturn<Boolean> {
    val result = orderMbpService.save(bo)

    val (jsessionid, jwt) = systemService.feign()

    val decreaseProductBO = DecreaseProductBO().apply {}
    val storageResult = storageServer.decreaseProduct(jsessionid, jwt, decreaseProductBO)
    storageResult.throwIfFailed()
    val decreaseAccountBO = DecreaseAccountBO().apply {}
    val accountResult = accountServer.decreaseMoney(jsessionid, jwt, decreaseAccountBO)
    accountResult.throwIfFailed()

    return JSONDataReturn.of(result)
  }

  override fun updateOrderStatus(bo: UpdateOrderStatusBO): JSONDataReturn<Boolean> {
    val update = orderMbpService.ktUpdateWrapper()
    update.set(TOrderEntity::status, 1)
    update.eq(TOrderEntity::userId, bo.userId)
    update.eq(TOrderEntity::status, bo.status)
    val result = update.update()
    return JSONDataReturn.of(result)
  }
}
