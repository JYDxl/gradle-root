@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.ArticleTagEntity;
import org.github.mysql.blog.base.mapper.IArticleTagMapper;
import org.github.mysql.blog.base.service.IArticleTagService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ArticleTagServiceImpl : ServiceImpl<IArticleTagMapper, ArticleTagEntity>(), IArticleTagService
