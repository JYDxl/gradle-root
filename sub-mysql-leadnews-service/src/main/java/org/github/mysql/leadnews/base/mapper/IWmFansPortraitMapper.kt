@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.WmFansPortraitEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 自媒体粉丝画像信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IWmFansPortraitMapper : IMapper<WmFansPortraitEntity>
