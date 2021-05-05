package org.github.base.service.impl;

import org.github.base.entity.RoleEntity;
import org.github.base.mapper.IRoleMapper;
import org.github.base.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, RoleEntity> implements IRoleService {}
