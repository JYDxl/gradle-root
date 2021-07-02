@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmUserAuthEntity;
import org.github.mysql.leadnews.base.mapper.IWmUserAuthMapper;
import org.github.mysql.leadnews.base.service.IWmUserAuthService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体子账号权限信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmUserAuthServiceImpl : ServiceImpl<IWmUserAuthMapper, WmUserAuthEntity>(), IWmUserAuthService
