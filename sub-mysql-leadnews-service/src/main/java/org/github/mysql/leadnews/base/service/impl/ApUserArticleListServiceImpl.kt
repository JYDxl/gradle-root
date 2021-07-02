@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserArticleListEntity;
import org.github.mysql.leadnews.base.mapper.IApUserArticleListMapper;
import org.github.mysql.leadnews.base.service.IApUserArticleListService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户文章列表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserArticleListServiceImpl : ServiceImpl<IApUserArticleListMapper, ApUserArticleListEntity>(), IApUserArticleListService
