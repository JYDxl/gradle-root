@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ClMaterialEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 爬得图文素材信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IClMaterialMapper : IMapper<ClMaterialEntity>
