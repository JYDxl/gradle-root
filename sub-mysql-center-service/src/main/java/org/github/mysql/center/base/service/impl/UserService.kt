@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.UserEntity;
import org.github.mysql.center.base.mapper.IUserMapper;
import org.github.mysql.center.base.service.IUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserService : ServiceImpl<IUserMapper, UserEntity>(), IUserService
