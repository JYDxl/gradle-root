@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.mapper;

import org.github.mysql.course.entity.MemberMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 会员 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IMemberMbpMapper : IMapper<MemberMbpPo>
