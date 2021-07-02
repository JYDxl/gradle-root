@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ClNewsMaterialEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 爬得图文引用素材信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IClNewsMaterialMapper : IMapper<ClNewsMaterialEntity>
