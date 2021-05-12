package org.github.base.service.impl;

import org.github.base.entity.SysRoleMenuEntity;
import org.github.base.mapper.ISysRoleMenuMapper;
import org.github.base.service.ISysRoleMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-12
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity> implements ISysRoleMenuService {}
