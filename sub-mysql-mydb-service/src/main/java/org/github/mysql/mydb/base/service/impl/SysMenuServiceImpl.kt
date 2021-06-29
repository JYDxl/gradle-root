@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysMenuEntity;
import org.github.mysql.mydb.base.mapper.ISysMenuMapper;
import org.github.mysql.mydb.base.service.ISysMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysMenuServiceImpl : ServiceImpl<ISysMenuMapper, SysMenuEntity>(), ISysMenuService
