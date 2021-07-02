@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmUserLoginEntity;
import org.github.mysql.leadnews.base.mapper.IWmUserLoginMapper;
import org.github.mysql.leadnews.base.service.IWmUserLoginService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体用户登录行为信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmUserLoginServiceImpl : ServiceImpl<IWmUserLoginMapper, WmUserLoginEntity>(), IWmUserLoginService
