@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApFollowBehaviorEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP关注行为表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApFollowBehaviorMapper : IMapper<ApFollowBehaviorEntity>
