@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserFollowEntity;
import org.github.mysql.leadnews.base.mapper.IApUserFollowMapper;
import org.github.mysql.leadnews.base.service.IApUserFollowService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户关注信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserFollowServiceImpl : ServiceImpl<IApUserFollowMapper, ApUserFollowEntity>(), IApUserFollowService
