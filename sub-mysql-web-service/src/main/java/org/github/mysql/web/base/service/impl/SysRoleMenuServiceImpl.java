package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysRoleMenuEntity;
import org.github.mysql.web.base.mapper.ISysRoleMenuMapper;
import org.github.mysql.web.base.service.ISysRoleMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity> implements ISysRoleMenuService {}
