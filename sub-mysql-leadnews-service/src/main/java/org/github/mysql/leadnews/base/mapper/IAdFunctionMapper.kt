@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdFunctionEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 页面功能信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdFunctionMapper : IMapper<AdFunctionEntity>
