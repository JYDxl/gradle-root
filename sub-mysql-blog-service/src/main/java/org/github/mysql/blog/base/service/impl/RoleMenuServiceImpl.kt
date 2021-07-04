@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.RoleMenuEntity;
import org.github.mysql.blog.base.mapper.IRoleMenuMapper;
import org.github.mysql.blog.base.service.IRoleMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleMenuServiceImpl : ServiceImpl<IRoleMenuMapper, RoleMenuEntity>(), IRoleMenuService
