@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApArticleLabelEntity;
import org.github.mysql.leadnews.base.mapper.IApArticleLabelMapper;
import org.github.mysql.leadnews.base.service.IApArticleLabelService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章标签信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApArticleLabelServiceImpl : ServiceImpl<IApArticleLabelMapper, ApArticleLabelEntity>(), IApArticleLabelService
