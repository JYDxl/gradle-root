@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzLocksEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzLocksMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzLocksService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzLocksServiceImpl : ServiceImpl<ICrawlerQrtzLocksMapper, CrawlerQrtzLocksEntity>(), ICrawlerQrtzLocksService
