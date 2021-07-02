@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzSimpleTriggersEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzSimpleTriggersMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzSimpleTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzSimpleTriggersServiceImpl : ServiceImpl<ICrawlerQrtzSimpleTriggersMapper, CrawlerQrtzSimpleTriggersEntity>(), ICrawlerQrtzSimpleTriggersService
