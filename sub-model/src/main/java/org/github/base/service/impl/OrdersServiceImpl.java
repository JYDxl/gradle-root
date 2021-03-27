package org.github.base.service.impl;

import org.github.base.entity.OrdersEntity;
import org.github.base.mapper.IOrdersMapper;
import org.github.base.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表; 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<IOrdersMapper, OrdersEntity> implements IOrdersService {}
