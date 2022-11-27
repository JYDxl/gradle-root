@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.AclPermissionEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 权限 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAclPermissionMapper : IMapper<AclPermissionEntity>
