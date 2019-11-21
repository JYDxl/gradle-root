package org.github.base.service.impl;

import org.github.base.entity.SysUserRoleEntity;
import org.github.base.mapper.ISysUserRoleMapper;
import org.github.base.service.ISysUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<ISysUserRoleMapper, SysUserRoleEntity> implements ISysUserRoleService {}
