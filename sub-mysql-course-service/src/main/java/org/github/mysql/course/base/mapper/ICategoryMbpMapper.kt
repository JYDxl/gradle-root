@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.CategoryMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 分类 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICategoryMbpMapper : IMapper<CategoryMbpEntity>