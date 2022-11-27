@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.AclAdminRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户角色 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAclAdminRoleMapper : IMapper<AclAdminRoleEntity>
