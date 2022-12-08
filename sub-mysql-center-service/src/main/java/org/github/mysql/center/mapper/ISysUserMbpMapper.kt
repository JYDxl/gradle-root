@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.mapper;

import org.github.mysql.center.entity.SysUserMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 用户 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysUserMbpMapper : IMapper<SysUserMbpPo>
