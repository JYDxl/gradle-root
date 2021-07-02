@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApArticleContentEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP已发布文章内容表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApArticleContentMapper : IMapper<ApArticleContentEntity>
