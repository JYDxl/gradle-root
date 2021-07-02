@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzSchedulerStateEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzSchedulerStateMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzSchedulerStateService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzSchedulerStateServiceImpl : ServiceImpl<ICrawlerQrtzSchedulerStateMapper, CrawlerQrtzSchedulerStateEntity>(), ICrawlerQrtzSchedulerStateService
