@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApHotArticlesEntity;
import org.github.mysql.leadnews.base.mapper.IApHotArticlesMapper;
import org.github.mysql.leadnews.base.service.IApHotArticlesService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 热文章表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApHotArticlesServiceImpl : ServiceImpl<IApHotArticlesMapper, ApHotArticlesEntity>(), IApHotArticlesService
