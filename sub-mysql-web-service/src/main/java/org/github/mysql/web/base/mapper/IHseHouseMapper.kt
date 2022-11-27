@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.HseHouseEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 房源表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IHseHouseMapper : IMapper<HseHouseEntity>
