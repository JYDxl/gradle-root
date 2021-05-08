package org.github.base.service.impl;

import org.github.base.entity.AdminMenuAuthEntity;
import org.github.base.mapper.IAdminMenuAuthMapper;
import org.github.base.service.IAdminMenuAuthService;
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
public class AdminMenuAuthServiceImpl extends ServiceImpl<IAdminMenuAuthMapper, AdminMenuAuthEntity> implements IAdminMenuAuthService {}
