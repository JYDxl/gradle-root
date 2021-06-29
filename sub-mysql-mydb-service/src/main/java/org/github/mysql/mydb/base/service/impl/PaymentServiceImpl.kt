@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.PaymentEntity;
import org.github.mysql.mydb.base.mapper.IPaymentMapper;
import org.github.mysql.mydb.base.service.IPaymentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 支付表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class PaymentServiceImpl : ServiceImpl<IPaymentMapper, PaymentEntity>(), IPaymentService
