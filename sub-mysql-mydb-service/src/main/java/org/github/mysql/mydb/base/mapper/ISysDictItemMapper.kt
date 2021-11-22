@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysDictItemEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 字典明细表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysDictItemMapper : IMapper<SysDictItemEntity>
