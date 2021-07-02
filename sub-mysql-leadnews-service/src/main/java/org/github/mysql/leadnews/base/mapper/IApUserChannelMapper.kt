@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApUserChannelEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP用户频道信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApUserChannelMapper : IMapper<ApUserChannelEntity>
