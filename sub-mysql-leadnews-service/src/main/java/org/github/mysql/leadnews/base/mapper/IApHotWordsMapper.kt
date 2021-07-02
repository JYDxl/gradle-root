@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApHotWordsEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 搜索热词表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApHotWordsMapper : IMapper<ApHotWordsEntity>
