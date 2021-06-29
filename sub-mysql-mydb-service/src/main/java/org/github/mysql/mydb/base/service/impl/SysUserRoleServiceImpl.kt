@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysUserRoleEntity;
import org.github.mysql.mydb.base.mapper.ISysUserRoleMapper;
import org.github.mysql.mydb.base.service.ISysUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户-角色关系表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserRoleServiceImpl : ServiceImpl<ISysUserRoleMapper, SysUserRoleEntity>(), ISysUserRoleService
