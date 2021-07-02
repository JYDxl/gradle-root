@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdChannelLabelEntity;
import org.github.mysql.leadnews.base.mapper.IAdChannelLabelMapper;
import org.github.mysql.leadnews.base.service.IAdChannelLabelService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 频道标签信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdChannelLabelServiceImpl : ServiceImpl<IAdChannelLabelMapper, AdChannelLabelEntity>(), IAdChannelLabelService
