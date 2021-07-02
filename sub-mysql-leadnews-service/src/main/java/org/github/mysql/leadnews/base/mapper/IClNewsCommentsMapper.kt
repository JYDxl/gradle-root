@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ClNewsCommentsEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 爬得图文评论信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IClNewsCommentsMapper : IMapper<ClNewsCommentsEntity>
