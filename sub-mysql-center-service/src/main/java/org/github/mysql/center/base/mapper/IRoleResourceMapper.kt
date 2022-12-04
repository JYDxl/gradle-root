@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.RoleResourceEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色资源关联 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IRoleResourceMapper : IMapper<RoleResourceEntity>
