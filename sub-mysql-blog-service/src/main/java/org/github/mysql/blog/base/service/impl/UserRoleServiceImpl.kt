@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.UserRoleEntity;
import org.github.mysql.blog.base.mapper.IUserRoleMapper;
import org.github.mysql.blog.base.service.IUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserRoleServiceImpl : ServiceImpl<IUserRoleMapper, UserRoleEntity>(), IUserRoleService
