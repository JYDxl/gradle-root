package org.github.base.mapper;

import org.github.base.entity.OrderItemsEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 订单商品关联表  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@MyBatisMapper
public interface IOrderItemsMapper extends IMapper<OrderItemsEntity> {}
