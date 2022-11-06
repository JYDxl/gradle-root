@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysCodeEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 数据字典表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysCodeMapper : IMapper<SysCodeEntity>
