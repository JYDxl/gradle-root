@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdArticleStatisticsEntity;
import org.github.mysql.leadnews.base.mapper.IAdArticleStatisticsMapper;
import org.github.mysql.leadnews.base.service.IAdArticleStatisticsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章数据统计表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdArticleStatisticsServiceImpl : ServiceImpl<IAdArticleStatisticsMapper, AdArticleStatisticsEntity>(), IAdArticleStatisticsService
