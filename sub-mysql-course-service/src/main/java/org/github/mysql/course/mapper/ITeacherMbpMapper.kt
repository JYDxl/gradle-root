@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.mapper;

import org.github.mysql.course.entity.TeacherMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 讲师 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITeacherMbpMapper : IMapper<TeacherMbpPo>
