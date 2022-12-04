@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.CourseEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 课程 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICourseMapper : IMapper<CourseEntity>
