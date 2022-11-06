@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysRoleResourceRelaEntity;
import org.github.mysql.sccore.base.mapper.ISysRoleResourceRelaMapper;
import org.github.mysql.sccore.base.service.ISysRoleResourceRelaService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色资源管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleResourceRelaServiceImpl : ServiceImpl<ISysRoleResourceRelaMapper, SysRoleResourceRelaEntity>(), ISysRoleResourceRelaService
