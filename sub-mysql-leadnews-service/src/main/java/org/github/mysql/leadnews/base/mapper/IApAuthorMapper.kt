@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApAuthorEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP文章作者信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApAuthorMapper : IMapper<ApAuthorEntity>
