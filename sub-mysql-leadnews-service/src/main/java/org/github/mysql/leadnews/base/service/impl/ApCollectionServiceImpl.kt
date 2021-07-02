@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApCollectionEntity;
import org.github.mysql.leadnews.base.mapper.IApCollectionMapper;
import org.github.mysql.leadnews.base.service.IApCollectionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP收藏信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApCollectionServiceImpl : ServiceImpl<IApCollectionMapper, ApCollectionEntity>(), IApCollectionService
