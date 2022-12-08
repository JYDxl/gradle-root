@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.mapper;

import org.github.mysql.course.entity.CourseContentFileMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 课程内容文件 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICourseContentFileMbpMapper : IMapper<CourseContentFileMbpPo>
