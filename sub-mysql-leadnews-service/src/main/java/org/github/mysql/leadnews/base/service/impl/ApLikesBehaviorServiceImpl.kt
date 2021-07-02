@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApLikesBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApLikesBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApLikesBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP点赞行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApLikesBehaviorServiceImpl : ServiceImpl<IApLikesBehaviorMapper, ApLikesBehaviorEntity>(), IApLikesBehaviorService
