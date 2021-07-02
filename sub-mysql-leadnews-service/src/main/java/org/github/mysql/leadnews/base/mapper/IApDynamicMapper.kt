@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApDynamicEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP用户动态信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApDynamicMapper : IMapper<ApDynamicEntity>
