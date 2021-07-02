@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.CrawlerQrtzPausedTriggerGrpsEntity;
import org.github.mysql.leadnews.base.mapper.ICrawlerQrtzPausedTriggerGrpsMapper;
import org.github.mysql.leadnews.base.service.ICrawlerQrtzPausedTriggerGrpsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CrawlerQrtzPausedTriggerGrpsServiceImpl : ServiceImpl<ICrawlerQrtzPausedTriggerGrpsMapper, CrawlerQrtzPausedTriggerGrpsEntity>(), ICrawlerQrtzPausedTriggerGrpsService
