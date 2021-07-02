@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApArticleConfigEntity;
import org.github.mysql.leadnews.base.mapper.IApArticleConfigMapper;
import org.github.mysql.leadnews.base.service.IApArticleConfigService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP已发布文章配置表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApArticleConfigServiceImpl : ServiceImpl<IApArticleConfigMapper, ApArticleConfigEntity>(), IApArticleConfigService
