@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdVistorStatisticsEntity;
import org.github.mysql.leadnews.base.mapper.IAdVistorStatisticsMapper;
import org.github.mysql.leadnews.base.service.IAdVistorStatisticsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 访问数据统计表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdVistorStatisticsServiceImpl : ServiceImpl<IAdVistorStatisticsMapper, AdVistorStatisticsEntity>(), IAdVistorStatisticsService
