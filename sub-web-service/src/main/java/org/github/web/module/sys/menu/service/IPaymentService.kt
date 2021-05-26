package org.github.web.module.sys.menu.service

import org.github.mysql.web.base.entity.PaymentMbpEntity

interface IPaymentService {
  fun create(bo: PaymentMbpEntity): Boolean

  fun get(id: Long): PaymentMbpEntity
}
