@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApArticleContentEntity;
import org.github.mysql.leadnews.base.mapper.IApArticleContentMapper;
import org.github.mysql.leadnews.base.service.IApArticleContentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP已发布文章内容表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApArticleContentServiceImpl : ServiceImpl<IApArticleContentMapper, ApArticleContentEntity>(), IApArticleContentService
