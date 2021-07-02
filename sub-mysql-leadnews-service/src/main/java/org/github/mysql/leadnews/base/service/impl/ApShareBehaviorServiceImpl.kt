@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApShareBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApShareBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApShareBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP分享行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApShareBehaviorServiceImpl : ServiceImpl<IApShareBehaviorMapper, ApShareBehaviorEntity>(), IApShareBehaviorService
