@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzFiredTriggersEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzFiredTriggersMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzFiredTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzFiredTriggersServiceImpl : ServiceImpl<ICrawlerQrtzFiredTriggersMapper, CrawlerQrtzFiredTriggersEntity>(), ICrawlerQrtzFiredTriggersService
