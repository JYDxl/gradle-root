@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.CategoryEntity;
import org.github.mysql.blog.base.mapper.ICategoryMapper;
import org.github.mysql.blog.base.service.ICategoryService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CategoryServiceImpl : ServiceImpl<ICategoryMapper, CategoryEntity>(), ICategoryService
