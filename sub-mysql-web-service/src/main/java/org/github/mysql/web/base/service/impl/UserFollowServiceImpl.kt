@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.UserFollowEntity;
import org.github.mysql.web.base.mapper.IUserFollowMapper;
import org.github.mysql.web.base.service.IUserFollowService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户关注表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserFollowServiceImpl : ServiceImpl<IUserFollowMapper, UserFollowEntity>(), IUserFollowService
