@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.AclRoleEntity;
import org.github.mysql.web.base.mapper.IAclRoleMapper;
import org.github.mysql.web.base.service.IAclRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AclRoleServiceImpl : ServiceImpl<IAclRoleMapper, AclRoleEntity>(), IAclRoleService
