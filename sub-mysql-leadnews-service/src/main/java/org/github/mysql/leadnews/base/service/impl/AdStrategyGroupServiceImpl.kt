@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdStrategyGroupEntity;
import org.github.mysql.leadnews.base.mapper.IAdStrategyGroupMapper;
import org.github.mysql.leadnews.base.service.IAdStrategyGroupService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 推荐策略分组信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdStrategyGroupServiceImpl : ServiceImpl<IAdStrategyGroupMapper, AdStrategyGroupEntity>(), IAdStrategyGroupService
