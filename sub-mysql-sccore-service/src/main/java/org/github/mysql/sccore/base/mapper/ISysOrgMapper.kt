@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysOrgEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 区域表，行政数据 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysOrgMapper : IMapper<SysOrgEntity>
