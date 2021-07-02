@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdUserLoginEntity;
import org.github.mysql.leadnews.base.mapper.IAdUserLoginMapper;
import org.github.mysql.leadnews.base.service.IAdUserLoginService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 管理员登录行为信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdUserLoginServiceImpl : ServiceImpl<IAdUserLoginMapper, AdUserLoginEntity>(), IAdUserLoginService
