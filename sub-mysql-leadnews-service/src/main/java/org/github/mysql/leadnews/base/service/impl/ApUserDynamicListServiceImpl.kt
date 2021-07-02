@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserDynamicListEntity;
import org.github.mysql.leadnews.base.mapper.IApUserDynamicListMapper;
import org.github.mysql.leadnews.base.service.IApUserDynamicListService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户动态列表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserDynamicListServiceImpl : ServiceImpl<IApUserDynamicListMapper, ApUserDynamicListEntity>(), IApUserDynamicListService
