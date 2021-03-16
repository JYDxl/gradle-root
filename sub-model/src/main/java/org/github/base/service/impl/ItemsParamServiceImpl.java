package org.github.base.service.impl;

import org.github.base.entity.ItemsParamEntity;
import org.github.base.mapper.IItemsParamMapper;
import org.github.base.service.IItemsParamService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品参数  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@Service
public class ItemsParamServiceImpl extends ServiceImpl<IItemsParamMapper, ItemsParamEntity> implements IItemsParamService {}
