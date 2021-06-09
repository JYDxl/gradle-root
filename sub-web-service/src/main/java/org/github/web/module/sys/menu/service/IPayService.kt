package org.github.web.module.sys.menu.service

import org.github.mysql.mydb.base.entity.PaymentEntity

interface IPayService {
  fun create(bo: PaymentEntity): Boolean

  fun get(id: Long): PaymentEntity
}
