@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysMenuEntity;
import org.github.mysql.sccore.base.mapper.ISysMenuMapper;
import org.github.mysql.sccore.base.service.ISysMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysMenuServiceImpl : ServiceImpl<ISysMenuMapper, SysMenuEntity>(), ISysMenuService
