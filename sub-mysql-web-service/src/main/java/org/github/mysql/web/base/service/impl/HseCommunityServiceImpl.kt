@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.HseCommunityEntity;
import org.github.mysql.web.base.mapper.IHseCommunityMapper;
import org.github.mysql.web.base.service.IHseCommunityService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 小区信息 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class HseCommunityServiceImpl : ServiceImpl<IHseCommunityMapper, HseCommunityEntity>(), IHseCommunityService
