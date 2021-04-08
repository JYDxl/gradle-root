package org.github.base.service.impl;

import org.github.base.entity.OrderItemsEntity;
import org.github.base.mapper.IOrderItemsMapper;
import org.github.base.service.IOrderItemsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品关联表  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Service
public class OrderItemsServiceImpl extends ServiceImpl<IOrderItemsMapper, OrderItemsEntity> implements IOrderItemsService {}
