@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.UserFollowEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户关注表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IUserFollowMapper : IMapper<UserFollowEntity>
