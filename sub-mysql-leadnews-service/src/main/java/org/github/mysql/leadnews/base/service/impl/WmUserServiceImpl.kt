@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmUserEntity;
import org.github.mysql.leadnews.base.mapper.IWmUserMapper;
import org.github.mysql.leadnews.base.service.IWmUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体用户信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmUserServiceImpl : ServiceImpl<IWmUserMapper, WmUserEntity>(), IWmUserService
