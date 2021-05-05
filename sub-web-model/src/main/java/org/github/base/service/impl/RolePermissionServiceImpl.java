package org.github.base.service.impl;

import org.github.base.entity.RolePermissionEntity;
import org.github.base.mapper.IRolePermissionMapper;
import org.github.base.service.IRolePermissionService;
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
public class RolePermissionServiceImpl extends ServiceImpl<IRolePermissionMapper, RolePermissionEntity> implements IRolePermissionService {}
