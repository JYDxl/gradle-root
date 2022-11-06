@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysRoleGroupEntity;
import org.github.mysql.sccore.base.mapper.ISysRoleGroupMapper;
import org.github.mysql.sccore.base.service.ISysRoleGroupService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色组管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleGroupServiceImpl : ServiceImpl<ISysRoleGroupMapper, SysRoleGroupEntity>(), ISysRoleGroupService
