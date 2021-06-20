@file:Suppress("RedundantSemicolon")

package org.github.mysql.seata.order.base.mapper;

import org.github.mysql.seata.order.base.entity.TOrderEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 订单表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITOrderMapper : IMapper<TOrderEntity>
