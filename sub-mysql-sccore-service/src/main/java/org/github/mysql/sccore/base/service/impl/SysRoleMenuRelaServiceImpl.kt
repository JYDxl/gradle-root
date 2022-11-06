@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysRoleMenuRelaEntity;
import org.github.mysql.sccore.base.mapper.ISysRoleMenuRelaMapper;
import org.github.mysql.sccore.base.service.ISysRoleMenuRelaService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色菜单管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleMenuRelaServiceImpl : ServiceImpl<ISysRoleMenuRelaMapper, SysRoleMenuRelaEntity>(), ISysRoleMenuRelaService
