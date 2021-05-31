@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysRoleMenuEntity;
import org.github.mysql.web.base.mapper.ISysRoleMenuMapper;
import org.github.mysql.web.base.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色与菜单对应关系 服务实现类
 *
 * @author JYD_XL
 * @since 2021-05-31
 */
@Service
open class SysRoleMenuServiceImpl : ServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity>(), ISysRoleMenuService
