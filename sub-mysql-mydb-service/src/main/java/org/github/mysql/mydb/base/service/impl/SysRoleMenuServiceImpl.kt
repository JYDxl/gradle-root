@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysRoleMenuEntity;
import org.github.mysql.mydb.base.mapper.ISysRoleMenuMapper;
import org.github.mysql.mydb.base.service.ISysRoleMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色-菜单关系表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleMenuServiceImpl : ServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity>(), ISysRoleMenuService
