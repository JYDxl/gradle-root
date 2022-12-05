@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.CourseContentFileMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 课程内容文件 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICourseContentFileMbpMapper : IMapper<CourseContentFileMbpEntity>