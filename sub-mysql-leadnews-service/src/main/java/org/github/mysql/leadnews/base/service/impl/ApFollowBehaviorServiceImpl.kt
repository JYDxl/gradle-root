@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApFollowBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApFollowBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApFollowBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP关注行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApFollowBehaviorServiceImpl : ServiceImpl<IApFollowBehaviorMapper, ApFollowBehaviorEntity>(), IApFollowBehaviorService
