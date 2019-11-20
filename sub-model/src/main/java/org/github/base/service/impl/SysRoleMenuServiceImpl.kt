package org.github.base.service.impl

import org.github.base.entity.SysRoleMenuEntity
import org.github.base.mapper.ISysRoleMenuMapper
import org.github.base.service.ISysRoleMenuService
import org.github.base.ServiceImpl
import org.springframework.stereotype.Service

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@Service
class SysRoleMenuServiceImpl: ServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity>(), ISysRoleMenuService
