@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.service.impl;

import org.github.mysql.blog.entity.BlogMbpPo;
import org.github.mysql.blog.mapper.IBlogMbpMapper;
import org.github.mysql.blog.service.IBlogMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class BlogMbpService : ServiceImpl<IBlogMbpMapper, BlogMbpPo>(), IBlogMbpService
