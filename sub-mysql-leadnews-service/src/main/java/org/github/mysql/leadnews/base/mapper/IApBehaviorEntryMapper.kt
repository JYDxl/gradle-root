@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApBehaviorEntryEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP行为实体表,一个行为实体可能是用户或者设备，或者其它 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApBehaviorEntryMapper : IMapper<ApBehaviorEntryEntity>
