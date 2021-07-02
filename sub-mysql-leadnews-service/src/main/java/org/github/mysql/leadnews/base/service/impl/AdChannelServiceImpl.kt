@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdChannelEntity;
import org.github.mysql.leadnews.base.mapper.IAdChannelMapper;
import org.github.mysql.leadnews.base.service.IAdChannelService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 频道信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdChannelServiceImpl : ServiceImpl<IAdChannelMapper, AdChannelEntity>(), IAdChannelService
