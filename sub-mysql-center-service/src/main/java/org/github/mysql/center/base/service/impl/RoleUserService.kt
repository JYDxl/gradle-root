@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.RoleUserEntity;
import org.github.mysql.center.base.mapper.IRoleUserMapper;
import org.github.mysql.center.base.service.IRoleUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色用户关联 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleUserService : ServiceImpl<IRoleUserMapper, RoleUserEntity>(), IRoleUserService
