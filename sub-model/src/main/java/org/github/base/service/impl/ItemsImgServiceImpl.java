package org.github.base.service.impl;

import org.github.base.entity.ItemsImgEntity;
import org.github.base.mapper.IItemsImgMapper;
import org.github.base.service.IItemsImgService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品图片  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Service
public class ItemsImgServiceImpl extends ServiceImpl<IItemsImgMapper, ItemsImgEntity> implements IItemsImgService {}
