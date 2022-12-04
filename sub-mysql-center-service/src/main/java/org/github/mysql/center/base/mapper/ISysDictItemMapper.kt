@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.SysDictItemEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 码值条目 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysDictItemMapper : IMapper<SysDictItemEntity>
