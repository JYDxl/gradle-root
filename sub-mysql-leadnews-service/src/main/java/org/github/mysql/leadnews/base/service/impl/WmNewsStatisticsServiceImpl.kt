@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmNewsStatisticsEntity;
import org.github.mysql.leadnews.base.mapper.IWmNewsStatisticsMapper;
import org.github.mysql.leadnews.base.service.IWmNewsStatisticsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体图文数据统计表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmNewsStatisticsServiceImpl : ServiceImpl<IWmNewsStatisticsMapper, WmNewsStatisticsEntity>(), IWmNewsStatisticsService
