@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.HseDictEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 组织架构表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IHseDictMapper : IMapper<HseDictEntity>
