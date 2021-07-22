@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApReadBehaviorEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP阅读行为表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApReadBehaviorMapper : IMapper<ApReadBehaviorEntity>