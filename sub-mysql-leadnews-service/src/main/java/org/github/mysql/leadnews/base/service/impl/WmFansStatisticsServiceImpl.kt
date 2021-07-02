@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmFansStatisticsEntity;
import org.github.mysql.leadnews.base.mapper.IWmFansStatisticsMapper;
import org.github.mysql.leadnews.base.service.IWmFansStatisticsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体粉丝数据统计表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmFansStatisticsServiceImpl : ServiceImpl<IWmFansStatisticsMapper, WmFansStatisticsEntity>(), IWmFansStatisticsService
