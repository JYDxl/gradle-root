package org.github.base.service.impl;

import org.github.base.entity.AdminRoleMenuEntity;
import org.github.base.mapper.IAdminRoleMenuMapper;
import org.github.base.service.IAdminRoleMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class AdminRoleMenuServiceImpl extends ServiceImpl<IAdminRoleMenuMapper, AdminRoleMenuEntity> implements IAdminRoleMenuService {}
