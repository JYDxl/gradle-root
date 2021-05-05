package org.github.base.service.impl;

import org.github.base.entity.TbUserRoleEntity;
import org.github.base.mapper.ITbUserRoleMapper;
import org.github.base.service.ITbUserRoleService;
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
public class TbUserRoleServiceImpl extends ServiceImpl<ITbUserRoleMapper, TbUserRoleEntity> implements ITbUserRoleService {}
