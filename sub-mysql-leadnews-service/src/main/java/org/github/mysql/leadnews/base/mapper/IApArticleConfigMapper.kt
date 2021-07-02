@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApArticleConfigEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP已发布文章配置表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApArticleConfigMapper : IMapper<ApArticleConfigEntity>
