package org.github.base.mapper;

import org.github.base.entity.OrderItemsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 订单商品关联表  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@MyBatisMapper
public interface IOrderItemsMapper extends BaseMapper<OrderItemsEntity> {}
