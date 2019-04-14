package org.github.base.service.impl;

import org.github.base.entity.SysRoleMenuEntity;
import org.github.base.mapper.ISysRoleMenuMapper;
import org.github.base.service.ISysRoleMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统-角色菜单关系表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-14
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity> implements ISysRoleMenuService {}
