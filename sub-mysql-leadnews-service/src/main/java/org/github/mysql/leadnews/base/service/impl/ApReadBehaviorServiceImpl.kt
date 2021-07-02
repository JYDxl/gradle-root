@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApReadBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApReadBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApReadBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP阅读行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApReadBehaviorServiceImpl : ServiceImpl<IApReadBehaviorMapper, ApReadBehaviorEntity>(), IApReadBehaviorService
