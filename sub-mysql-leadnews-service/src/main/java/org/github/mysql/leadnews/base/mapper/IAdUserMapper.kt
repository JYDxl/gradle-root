@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 管理员用户信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdUserMapper : IMapper<AdUserEntity>
