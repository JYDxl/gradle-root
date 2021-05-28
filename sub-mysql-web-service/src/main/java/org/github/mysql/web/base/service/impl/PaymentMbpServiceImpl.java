package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.PaymentMbpEntity;
import org.github.mysql.web.base.mapper.IPaymentMbpMapper;
import org.github.mysql.web.base.service.IPaymentMbpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-28
 */
@Service
public class PaymentMbpServiceImpl extends ServiceImpl<IPaymentMbpMapper, PaymentMbpEntity> implements IPaymentMbpService {}
