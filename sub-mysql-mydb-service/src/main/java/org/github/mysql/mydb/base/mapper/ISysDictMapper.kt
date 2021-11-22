@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysDictEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 字典总表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysDictMapper : IMapper<SysDictEntity>
