@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApArticleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 文章信息表，存储已发布的文章 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApArticleMapper : IMapper<ApArticleEntity>
