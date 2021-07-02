@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApShowBehaviorEntity;
import org.github.mysql.leadnews.base.mapper.IApShowBehaviorMapper;
import org.github.mysql.leadnews.base.service.IApShowBehaviorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP文章展现行为表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApShowBehaviorServiceImpl : ServiceImpl<IApShowBehaviorMapper, ApShowBehaviorEntity>(), IApShowBehaviorService
