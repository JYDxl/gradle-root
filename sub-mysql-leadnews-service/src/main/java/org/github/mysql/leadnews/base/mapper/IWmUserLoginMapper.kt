@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.WmUserLoginEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 自媒体用户登录行为信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IWmUserLoginMapper : IMapper<WmUserLoginEntity>
