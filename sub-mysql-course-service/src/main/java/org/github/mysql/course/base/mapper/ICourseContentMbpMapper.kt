@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.CourseContentMbpEntity;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 课程内容 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICourseContentMbpMapper : IMapper<CourseContentMbpEntity>
