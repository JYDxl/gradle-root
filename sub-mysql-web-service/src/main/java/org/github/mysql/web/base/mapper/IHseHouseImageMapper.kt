@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.HseHouseImageEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 房源图片 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IHseHouseImageMapper : IMapper<HseHouseImageEntity>
