@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.TeacherMbpEntity;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 讲师 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITeacherMbpMapper : IMapper<TeacherMbpEntity>
