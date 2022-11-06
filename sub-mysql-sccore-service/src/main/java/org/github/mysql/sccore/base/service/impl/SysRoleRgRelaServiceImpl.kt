@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysRoleRgRelaEntity;
import org.github.mysql.sccore.base.mapper.ISysRoleRgRelaMapper;
import org.github.mysql.sccore.base.service.ISysRoleRgRelaService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色-角色组关系 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysRoleRgRelaServiceImpl : ServiceImpl<ISysRoleRgRelaMapper, SysRoleRgRelaEntity>(), ISysRoleRgRelaService
