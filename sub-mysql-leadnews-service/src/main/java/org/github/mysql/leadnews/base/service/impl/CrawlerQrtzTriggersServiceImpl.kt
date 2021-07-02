@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzTriggersEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzTriggersMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzTriggersServiceImpl : ServiceImpl<ICrawlerQrtzTriggersMapper, CrawlerQrtzTriggersEntity>(), ICrawlerQrtzTriggersService
