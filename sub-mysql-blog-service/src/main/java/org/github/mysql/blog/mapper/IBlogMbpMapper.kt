@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.mapper;

import org.github.mysql.blog.entity.BlogMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 *  Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IBlogMbpMapper : IMapper<BlogMbpPo>
