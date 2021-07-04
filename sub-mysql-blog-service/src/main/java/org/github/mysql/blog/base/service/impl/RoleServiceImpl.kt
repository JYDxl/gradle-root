@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.RoleEntity;
import org.github.mysql.blog.base.mapper.IRoleMapper;
import org.github.mysql.blog.base.service.IRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleServiceImpl : ServiceImpl<IRoleMapper, RoleEntity>(), IRoleService
