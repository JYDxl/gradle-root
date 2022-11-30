@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.AclRolePermissionEntity;
import org.github.mysql.web.base.mapper.IAclRolePermissionMapper;
import org.github.mysql.web.base.service.IAclRolePermissionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色权限 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AclRolePermissionService : ServiceImpl<IAclRolePermissionMapper, AclRolePermissionEntity>(), IAclRolePermissionService
