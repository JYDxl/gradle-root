@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.RoleUserMbpPo;
import org.github.mysql.center.mapper.IRoleUserMbpMapper;
import org.github.mysql.center.service.IRoleUserMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色用户关联 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleUserMbpService : ServiceImpl<IRoleUserMbpMapper, RoleUserMbpPo>(), IRoleUserMbpService
