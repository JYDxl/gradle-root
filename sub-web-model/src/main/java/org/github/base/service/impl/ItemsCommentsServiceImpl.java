package org.github.base.service.impl;

import org.github.base.entity.ItemsCommentsEntity;
import org.github.base.mapper.IItemsCommentsMapper;
import org.github.base.service.IItemsCommentsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Service
public class ItemsCommentsServiceImpl extends ServiceImpl<IItemsCommentsMapper, ItemsCommentsEntity> implements IItemsCommentsService {}
