@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserEntity;
import org.github.mysql.leadnews.base.mapper.IApUserMapper;
import org.github.mysql.leadnews.base.service.IApUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserServiceImpl : ServiceImpl<IApUserMapper, ApUserEntity>(), IApUserService
