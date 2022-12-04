@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.RoleEntity;
import org.github.mysql.center.base.mapper.IRoleMapper;
import org.github.mysql.center.base.service.IRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleService : ServiceImpl<IRoleMapper, RoleEntity>(), IRoleService
