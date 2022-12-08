@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.UserMbpPo;
import org.github.mysql.center.mapper.IUserMbpMapper;
import org.github.mysql.center.service.IUserMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserMbpService : ServiceImpl<IUserMbpMapper, UserMbpPo>(), IUserMbpService
