@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApDynamicEntity;
import org.github.mysql.leadnews.base.mapper.IApDynamicMapper;
import org.github.mysql.leadnews.base.service.IApDynamicService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户动态信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApDynamicServiceImpl : ServiceImpl<IApDynamicMapper, ApDynamicEntity>(), IApDynamicService
