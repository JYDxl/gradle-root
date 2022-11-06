@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysUserRoleEntity;
import org.github.mysql.sccore.base.mapper.ISysUserRoleMapper;
import org.github.mysql.sccore.base.service.ISysUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户角色管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserRoleServiceImpl : ServiceImpl<ISysUserRoleMapper, SysUserRoleEntity>(), ISysUserRoleService
