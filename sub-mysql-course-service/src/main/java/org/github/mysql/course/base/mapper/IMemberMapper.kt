@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.MemberEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 会员 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IMemberMapper : IMapper<MemberEntity>
