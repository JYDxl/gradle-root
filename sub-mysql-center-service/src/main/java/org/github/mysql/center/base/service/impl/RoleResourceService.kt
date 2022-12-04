@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.RoleResourceEntity;
import org.github.mysql.center.base.mapper.IRoleResourceMapper;
import org.github.mysql.center.base.service.IRoleResourceService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色资源关联 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleResourceService : ServiceImpl<IRoleResourceMapper, RoleResourceEntity>(), IRoleResourceService
