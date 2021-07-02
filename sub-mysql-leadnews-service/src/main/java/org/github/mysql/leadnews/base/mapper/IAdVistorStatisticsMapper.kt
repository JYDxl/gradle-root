@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdVistorStatisticsEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 访问数据统计表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdVistorStatisticsMapper : IMapper<AdVistorStatisticsEntity>
