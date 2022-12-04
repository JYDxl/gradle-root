@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.RoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IRoleMapper : IMapper<RoleEntity>
