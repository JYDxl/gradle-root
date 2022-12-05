@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.RoleResourceMbpEntity;
import org.github.mysql.center.base.mapper.IRoleResourceMbpMapper;
import org.github.mysql.center.base.service.IRoleResourceMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色资源关联 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleResourceMbpService : ServiceImpl<IRoleResourceMbpMapper, RoleResourceMbpEntity>(), IRoleResourceMbpService
