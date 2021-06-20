@file:Suppress("RedundantSemicolon")

package org.github.mysql.seata.storage.base.mapper;

import org.github.mysql.seata.storage.base.entity.TStorageEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 库存表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITStorageMapper : IMapper<TStorageEntity>
