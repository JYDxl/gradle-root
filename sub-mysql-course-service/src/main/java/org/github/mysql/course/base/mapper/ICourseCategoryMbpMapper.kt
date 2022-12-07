@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.CourseCategoryMbpEntity;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 课程分类 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICourseCategoryMbpMapper : IMapper<CourseCategoryMbpEntity>
