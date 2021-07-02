@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.WmUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 自媒体用户信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IWmUserMapper : IMapper<WmUserEntity>
