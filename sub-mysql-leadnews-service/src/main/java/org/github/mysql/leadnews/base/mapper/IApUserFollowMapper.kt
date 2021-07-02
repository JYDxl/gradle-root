@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApUserFollowEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP用户关注信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApUserFollowMapper : IMapper<ApUserFollowEntity>
