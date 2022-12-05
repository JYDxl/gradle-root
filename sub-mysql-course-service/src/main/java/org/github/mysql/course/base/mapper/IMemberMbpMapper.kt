@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.MemberMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 会员 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IMemberMbpMapper : IMapper<MemberMbpEntity>
