@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.UserAuthEntity;
import org.github.mysql.blog.base.mapper.IUserAuthMapper;
import org.github.mysql.blog.base.service.IUserAuthService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户登录信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserAuthServiceImpl : ServiceImpl<IUserAuthMapper, UserAuthEntity>(), IUserAuthService
