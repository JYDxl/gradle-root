@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdStrategyGroupEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 推荐策略分组信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdStrategyGroupMapper : IMapper<AdStrategyGroupEntity>
