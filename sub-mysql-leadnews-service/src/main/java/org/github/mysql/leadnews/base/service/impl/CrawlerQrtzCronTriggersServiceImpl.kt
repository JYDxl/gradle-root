@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzCronTriggersEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzCronTriggersMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzCronTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzCronTriggersServiceImpl : ServiceImpl<ICrawlerQrtzCronTriggersMapper, CrawlerQrtzCronTriggersEntity>(), ICrawlerQrtzCronTriggersService
