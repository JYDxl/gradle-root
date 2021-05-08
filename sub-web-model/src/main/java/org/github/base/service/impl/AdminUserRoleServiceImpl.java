package org.github.base.service.impl;

import org.github.base.entity.AdminUserRoleEntity;
import org.github.base.mapper.IAdminUserRoleMapper;
import org.github.base.service.IAdminUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class AdminUserRoleServiceImpl extends ServiceImpl<IAdminUserRoleMapper, AdminUserRoleEntity> implements IAdminUserRoleService {}
