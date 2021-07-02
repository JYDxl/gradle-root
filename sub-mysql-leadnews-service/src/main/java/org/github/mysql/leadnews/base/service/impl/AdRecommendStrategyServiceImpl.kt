@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdRecommendStrategyEntity;
import org.github.mysql.leadnews.base.mapper.IAdRecommendStrategyMapper;
import org.github.mysql.leadnews.base.service.IAdRecommendStrategyService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 推荐策略信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdRecommendStrategyServiceImpl : ServiceImpl<IAdRecommendStrategyMapper, AdRecommendStrategyEntity>(), IAdRecommendStrategyService
