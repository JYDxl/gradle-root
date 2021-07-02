@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdRecommendStrategyEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 推荐策略信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdRecommendStrategyMapper : IMapper<AdRecommendStrategyEntity>
