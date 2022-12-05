@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.UserMbpEntity;
import org.github.mysql.center.base.mapper.IUserMbpMapper;
import org.github.mysql.center.base.service.IUserMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserMbpService : ServiceImpl<IUserMbpMapper, UserMbpEntity>(), IUserMbpService
