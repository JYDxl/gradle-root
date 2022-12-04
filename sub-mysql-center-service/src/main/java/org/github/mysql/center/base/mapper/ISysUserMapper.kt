@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.SysUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysUserMapper : IMapper<SysUserEntity>
