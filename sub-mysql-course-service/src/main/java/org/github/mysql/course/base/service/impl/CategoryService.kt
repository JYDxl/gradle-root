@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CategoryEntity;
import org.github.mysql.course.base.mapper.ICategoryMapper;
import org.github.mysql.course.base.service.ICategoryService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 分类 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CategoryService : ServiceImpl<ICategoryMapper, CategoryEntity>(), ICategoryService
