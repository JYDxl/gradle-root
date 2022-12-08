@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.RoleResourceMbpPo;
import org.github.mysql.center.mapper.IRoleResourceMbpMapper;
import org.github.mysql.center.service.IRoleResourceMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色资源关联 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleResourceMbpService : ServiceImpl<IRoleResourceMbpMapper, RoleResourceMbpPo>(), IRoleResourceMbpService
