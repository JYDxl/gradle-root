@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.MemberCourseEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 会员课程报名 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IMemberCourseMapper : IMapper<MemberCourseEntity>
