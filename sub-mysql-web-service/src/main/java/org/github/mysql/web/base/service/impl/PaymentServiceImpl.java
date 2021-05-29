package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.PaymentEntity;
import org.github.mysql.web.base.mapper.IPaymentMapper;
import org.github.mysql.web.base.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<IPaymentMapper, PaymentEntity> implements IPaymentService {}
