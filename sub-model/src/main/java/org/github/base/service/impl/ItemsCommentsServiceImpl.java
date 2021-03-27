package org.github.base.service.impl;

import org.github.base.entity.ItemsCommentsEntity;
import org.github.base.mapper.IItemsCommentsMapper;
import org.github.base.service.IItemsCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class ItemsCommentsServiceImpl extends ServiceImpl<IItemsCommentsMapper, ItemsCommentsEntity> implements IItemsCommentsService {}
