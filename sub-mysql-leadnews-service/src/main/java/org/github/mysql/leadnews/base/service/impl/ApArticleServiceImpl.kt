@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApArticleEntity;
import org.github.mysql.leadnews.base.mapper.IApArticleMapper;
import org.github.mysql.leadnews.base.service.IApArticleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章信息表，存储已发布的文章 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApArticleServiceImpl : ServiceImpl<IApArticleMapper, ApArticleEntity>(), IApArticleService
