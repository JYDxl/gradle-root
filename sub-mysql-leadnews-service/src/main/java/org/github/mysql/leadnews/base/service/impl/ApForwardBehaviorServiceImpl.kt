@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApForwardBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApForwardBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApForwardBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP转发行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApForwardBehaviorServiceImpl : ServiceImpl<IApForwardBehaviorMapper, ApForwardBehaviorEntity>(), IApForwardBehaviorService
