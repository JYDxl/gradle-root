@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ClTaskLogEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 爬取日志表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IClTaskLogMapper : IMapper<ClTaskLogEntity>
