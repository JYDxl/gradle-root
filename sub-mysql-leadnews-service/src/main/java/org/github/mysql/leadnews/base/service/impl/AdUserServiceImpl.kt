@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdUserEntity;
import org.github.mysql.leadnews.base.mapper.IAdUserMapper;
import org.github.mysql.leadnews.base.service.IAdUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 管理员用户信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdUserServiceImpl : ServiceImpl<IAdUserMapper, AdUserEntity>(), IAdUserService
