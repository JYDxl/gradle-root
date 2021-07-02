@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApCommentRepayEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP评论回复信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApCommentRepayMapper : IMapper<ApCommentRepayEntity>
