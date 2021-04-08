package org.github.base.mapper;

import org.github.base.entity.OrdersEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 订单表; Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@MyBatisMapper
public interface IOrdersMapper extends IMapper<OrdersEntity> {}
