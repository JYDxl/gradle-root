package org.github.base.service.impl;

import org.github.base.entity.UserRoleEntity;
import org.github.base.mapper.IUserRoleMapper;
import org.github.base.service.IUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<IUserRoleMapper, UserRoleEntity> implements IUserRoleService {}
