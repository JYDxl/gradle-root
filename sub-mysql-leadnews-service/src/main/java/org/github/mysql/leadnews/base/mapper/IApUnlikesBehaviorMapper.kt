@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApUnlikesBehaviorEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP不喜欢行为表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApUnlikesBehaviorMapper : IMapper<ApUnlikesBehaviorEntity>
