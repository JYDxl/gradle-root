@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.AclAdminRoleEntity;
import org.github.mysql.web.base.mapper.IAclAdminRoleMapper;
import org.github.mysql.web.base.service.IAclAdminRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户角色 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AclAdminRoleService : ServiceImpl<IAclAdminRoleMapper, AclAdminRoleEntity>(), IAclAdminRoleService
