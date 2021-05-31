@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.PaymentEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 支付表 Mapper 接口
 *
 * @author JYD_XL
 * @since 2021-05-31
 */
@MyBatisMapper
interface IPaymentMapper : IMapper<PaymentEntity>
