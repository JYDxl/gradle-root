@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzBlobTriggersEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzBlobTriggersMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzBlobTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzBlobTriggersServiceImpl : ServiceImpl<ICrawlerQrtzBlobTriggersMapper, CrawlerQrtzBlobTriggersEntity>(), ICrawlerQrtzBlobTriggersService
