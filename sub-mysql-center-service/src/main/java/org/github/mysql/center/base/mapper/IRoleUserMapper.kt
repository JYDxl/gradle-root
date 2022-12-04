@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.RoleUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色用户关联 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IRoleUserMapper : IMapper<RoleUserEntity>
