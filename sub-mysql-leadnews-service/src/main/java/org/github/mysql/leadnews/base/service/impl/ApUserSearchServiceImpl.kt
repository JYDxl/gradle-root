@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserSearchEntity;
import org.github.mysql.leadnews.base.mapper.IApUserSearchMapper;
import org.github.mysql.leadnews.base.service.IApUserSearchService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户搜索信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserSearchServiceImpl : ServiceImpl<IApUserSearchMapper, ApUserSearchEntity>(), IApUserSearchService
