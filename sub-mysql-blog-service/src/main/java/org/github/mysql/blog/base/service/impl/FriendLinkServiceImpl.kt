@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.FriendLinkEntity;
import org.github.mysql.blog.base.mapper.IFriendLinkMapper;
import org.github.mysql.blog.base.service.IFriendLinkService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class FriendLinkServiceImpl : ServiceImpl<IFriendLinkMapper, FriendLinkEntity>(), IFriendLinkService
