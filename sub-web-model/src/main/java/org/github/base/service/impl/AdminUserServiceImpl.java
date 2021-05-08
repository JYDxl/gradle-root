package org.github.base.service.impl;

import org.github.base.entity.AdminUserEntity;
import org.github.base.mapper.IAdminUserMapper;
import org.github.base.service.IAdminUserService;
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
public class AdminUserServiceImpl extends ServiceImpl<IAdminUserMapper, AdminUserEntity> implements IAdminUserService {}
