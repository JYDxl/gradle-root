@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzJobDetailsEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzJobDetailsMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzJobDetailsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzJobDetailsServiceImpl : ServiceImpl<ICrawlerQrtzJobDetailsMapper, CrawlerQrtzJobDetailsEntity>(), ICrawlerQrtzJobDetailsService
