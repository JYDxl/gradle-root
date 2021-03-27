package org.github.base.service.impl;

import org.github.base.entity.CategoryEntity;
import org.github.base.mapper.ICategoryMapper;
import org.github.base.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<ICategoryMapper, CategoryEntity> implements ICategoryService {}
