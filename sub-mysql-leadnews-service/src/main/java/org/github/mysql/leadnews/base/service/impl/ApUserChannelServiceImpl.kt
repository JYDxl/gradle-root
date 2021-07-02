@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserChannelEntity;
import org.github.mysql.leadnews.base.mapper.IApUserChannelMapper;
import org.github.mysql.leadnews.base.service.IApUserChannelService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户频道信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserChannelServiceImpl : ServiceImpl<IApUserChannelMapper, ApUserChannelEntity>(), IApUserChannelService
