@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzCalendarsEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzCalendarsMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzCalendarsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzCalendarsServiceImpl : ServiceImpl<ICrawlerQrtzCalendarsMapper, CrawlerQrtzCalendarsEntity>(), ICrawlerQrtzCalendarsService
