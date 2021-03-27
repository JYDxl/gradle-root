package org.github.base.service.impl;

import org.github.base.entity.ItemsEntity;
import org.github.base.mapper.IItemsMapper;
import org.github.base.service.IItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<IItemsMapper, ItemsEntity> implements IItemsService {}
