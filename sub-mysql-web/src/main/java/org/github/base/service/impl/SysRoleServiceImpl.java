package org.github.base.service.impl;

import org.github.base.entity.SysRoleEntity;
import org.github.base.mapper.ISysRoleMapper;
import org.github.base.service.ISysRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<ISysRoleMapper, SysRoleEntity> implements ISysRoleService {}
