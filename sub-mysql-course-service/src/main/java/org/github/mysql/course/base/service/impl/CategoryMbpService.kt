@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CategoryMbpEntity;
import org.github.mysql.course.base.mapper.ICategoryMbpMapper;
import org.github.mysql.course.base.service.ICategoryMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 分类 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CategoryMbpService : ServiceImpl<ICategoryMbpMapper, CategoryMbpEntity>(), ICategoryMbpService
