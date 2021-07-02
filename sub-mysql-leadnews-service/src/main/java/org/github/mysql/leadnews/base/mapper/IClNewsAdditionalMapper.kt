@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ClNewsAdditionalEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 爬得图文附属信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IClNewsAdditionalMapper : IMapper<ClNewsAdditionalEntity>
