@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.WmSubUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 自媒体子账号信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IWmSubUserMapper : IMapper<WmSubUserEntity>
