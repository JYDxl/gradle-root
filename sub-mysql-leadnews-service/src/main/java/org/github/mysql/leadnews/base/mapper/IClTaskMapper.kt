@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ClTaskEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 爬虫任务信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IClTaskMapper : IMapper<ClTaskEntity>
