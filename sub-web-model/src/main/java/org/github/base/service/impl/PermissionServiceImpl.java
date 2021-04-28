package org.github.base.service.impl;

import org.github.base.entity.PermissionEntity;
import org.github.base.mapper.IPermissionMapper;
import org.github.base.service.IPermissionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-21
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionMapper, PermissionEntity> implements IPermissionService {}
