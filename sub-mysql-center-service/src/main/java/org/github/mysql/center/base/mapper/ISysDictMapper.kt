@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.SysDictEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 码值类型 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysDictMapper : IMapper<SysDictEntity>
