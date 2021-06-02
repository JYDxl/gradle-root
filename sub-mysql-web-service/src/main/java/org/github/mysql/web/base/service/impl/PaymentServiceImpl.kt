@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.PaymentEntity;
import org.github.mysql.web.base.mapper.IPaymentMapper;
import org.github.mysql.web.base.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 支付表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class PaymentServiceImpl : ServiceImpl<IPaymentMapper, PaymentEntity>(), IPaymentService
