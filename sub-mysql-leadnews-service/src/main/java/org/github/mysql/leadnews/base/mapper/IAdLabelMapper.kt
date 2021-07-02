@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdLabelEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 标签信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdLabelMapper : IMapper<AdLabelEntity>
