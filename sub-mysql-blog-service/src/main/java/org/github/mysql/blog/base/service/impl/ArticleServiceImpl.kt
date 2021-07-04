@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.ArticleEntity;
import org.github.mysql.blog.base.mapper.IArticleMapper;
import org.github.mysql.blog.base.service.IArticleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ArticleServiceImpl : ServiceImpl<IArticleMapper, ArticleEntity>(), IArticleService
