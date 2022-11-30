@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysUserRoleGroupRelaEntity;
import org.github.mysql.sccore.base.mapper.ISysUserRoleGroupRelaMapper;
import org.github.mysql.sccore.base.service.ISysUserRoleGroupRelaService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户角色组管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserRoleGroupRelaService : ServiceImpl<ISysUserRoleGroupRelaMapper, SysUserRoleGroupRelaEntity>(), ISysUserRoleGroupRelaService
