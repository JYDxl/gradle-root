@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzSimpropTriggersEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzSimpropTriggersMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzSimpropTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzSimpropTriggersServiceImpl : ServiceImpl<ICrawlerQrtzSimpropTriggersMapper, CrawlerQrtzSimpropTriggersEntity>(), ICrawlerQrtzSimpropTriggersService
