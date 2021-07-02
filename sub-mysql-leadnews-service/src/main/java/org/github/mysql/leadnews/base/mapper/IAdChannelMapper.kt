@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdChannelEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 频道信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdChannelMapper : IMapper<AdChannelEntity>
