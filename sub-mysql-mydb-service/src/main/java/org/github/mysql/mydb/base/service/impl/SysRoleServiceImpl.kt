@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysRoleEntity;
import org.github.mysql.mydb.base.mapper.ISysRoleMapper;
import org.github.mysql.mydb.base.service.ISysRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleServiceImpl : ServiceImpl<ISysRoleMapper, SysRoleEntity>(), ISysRoleService
