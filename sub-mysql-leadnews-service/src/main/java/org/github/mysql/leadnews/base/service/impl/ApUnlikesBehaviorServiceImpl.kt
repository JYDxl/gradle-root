@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUnlikesBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApUnlikesBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApUnlikesBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP不喜欢行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUnlikesBehaviorServiceImpl : ServiceImpl<IApUnlikesBehaviorMapper, ApUnlikesBehaviorEntity>(), IApUnlikesBehaviorService
