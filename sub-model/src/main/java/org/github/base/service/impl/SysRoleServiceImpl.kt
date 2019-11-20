package org.github.base.service.impl

import org.github.base.entity.SysRoleEntity
import org.github.base.mapper.ISysRoleMapper
import org.github.base.service.ISysRoleService
import org.github.base.ServiceImpl
import org.springframework.stereotype.Service

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@Service
class SysRoleServiceImpl: ServiceImpl<ISysRoleMapper, SysRoleEntity>(), ISysRoleService
