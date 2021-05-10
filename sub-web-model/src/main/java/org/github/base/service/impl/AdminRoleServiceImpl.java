package org.github.base.service.impl;

import org.github.base.entity.AdminRoleEntity;
import org.github.base.mapper.IAdminRoleMapper;
import org.github.base.service.IAdminRoleService;
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
public class AdminRoleServiceImpl extends ServiceImpl<IAdminRoleMapper, AdminRoleEntity> implements IAdminRoleService {}