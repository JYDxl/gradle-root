@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdMenuEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 菜单资源信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdMenuMapper : IMapper<AdMenuEntity>
