package org.github.order.service.impl

import io.seata.spring.annotation.GlobalTransactional
import org.github.account.dto.DecreaseAccountBO
import org.github.account.feign.IServiceProviderAccountServer
import org.github.mybatis.ops.ktUpdateWrapper
import org.github.mysql.seata.order.base.dict.OrderStatus.END
import org.github.mysql.seata.order.base.entity.TOrderEntity
import org.github.mysql.seata.order.base.service.ITOrderService
import org.github.order.dto.CreateOrderBO
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

  @GlobalTransactional(rollbackFor = [Exception::class])
  override fun createOrder(bo: CreateOrderBO): JSONDataReturn<Boolean> {
    /*
     * 1.创建订单
     * 2.减库存
     * 3.减金额
     * 4.修改订单状态
     */

    //1.创建订单
    val result = orderMbpService.save(bo)
    //生成token
    val (jsessionid, jwt) = systemService.feign()

    //2.减库存
    val decreaseProductBO = DecreaseProductBO().apply {
      productId = bo.productId
      count = bo.num
    }
    storageServer.decreaseProduct(jsessionid, jwt, decreaseProductBO)

    //3.减金额
    val decreaseAccountBO = DecreaseAccountBO().apply {
      userId = bo.userId
      money = bo.money
    }
    accountServer.decreaseMoney(jsessionid, jwt, decreaseAccountBO)

    //4.修改订单状态
    val update = orderMbpService.ktUpdateWrapper()
    update.set(TOrderEntity::status, END.code)
    update.eq(TOrderEntity::orderId, bo.orderId)
    update.update()

    return JSONDataReturn.of(result)
  }
}
