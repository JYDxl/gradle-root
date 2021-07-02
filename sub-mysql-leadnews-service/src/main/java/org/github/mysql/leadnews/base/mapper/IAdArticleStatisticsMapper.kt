@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdArticleStatisticsEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 文章数据统计表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdArticleStatisticsMapper : IMapper<AdArticleStatisticsEntity>
