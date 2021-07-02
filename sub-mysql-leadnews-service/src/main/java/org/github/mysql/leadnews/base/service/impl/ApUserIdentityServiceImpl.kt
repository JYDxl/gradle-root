@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserIdentityEntity;
import org.github.mysql.leadnews.base.mapper.IApUserIdentityMapper;
import org.github.mysql.leadnews.base.service.IApUserIdentityService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP身份认证信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserIdentityServiceImpl : ServiceImpl<IApUserIdentityMapper, ApUserIdentityEntity>(), IApUserIdentityService
