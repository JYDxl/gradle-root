@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdSensitiveEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 敏感词信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdSensitiveMapper : IMapper<AdSensitiveEntity>
