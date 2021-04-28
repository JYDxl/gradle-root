package org.github.base.service.impl;

import org.github.base.entity.ItemsSpecEntity;
import org.github.base.mapper.IItemsSpecMapper;
import org.github.base.service.IItemsSpecService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Service
public class ItemsSpecServiceImpl extends ServiceImpl<IItemsSpecMapper, ItemsSpecEntity> implements IItemsSpecService {}
