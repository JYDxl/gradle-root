@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.AclRolePermissionEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色权限 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAclRolePermissionMapper : IMapper<AclRolePermissionEntity>
