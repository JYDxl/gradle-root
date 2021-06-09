@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SpAttributeEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 属性表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISpAttributeMapper : IMapper<SpAttributeEntity>
