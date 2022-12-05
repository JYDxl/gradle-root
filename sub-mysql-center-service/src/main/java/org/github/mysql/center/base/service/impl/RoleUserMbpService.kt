@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.RoleUserMbpEntity;
import org.github.mysql.center.base.mapper.IRoleUserMbpMapper;
import org.github.mysql.center.base.service.IRoleUserMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色用户关联 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleUserMbpService : ServiceImpl<IRoleUserMbpMapper, RoleUserMbpEntity>(), IRoleUserMbpService
