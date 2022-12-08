@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.CategoryMbpPo;
import org.github.mysql.course.mapper.ICategoryMbpMapper;
import org.github.mysql.course.service.ICategoryMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 分类 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CategoryMbpService : ServiceImpl<ICategoryMbpMapper, CategoryMbpPo>(), ICategoryMbpService
