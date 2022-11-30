@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysRoleEntity;
import org.github.mysql.sccore.base.mapper.ISysRoleMapper;
import org.github.mysql.sccore.base.service.ISysRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleService : ServiceImpl<ISysRoleMapper, SysRoleEntity>(), ISysRoleService
