@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmSubUserEntity;
import org.github.mysql.leadnews.base.mapper.IWmSubUserMapper;
import org.github.mysql.leadnews.base.service.IWmSubUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体子账号信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmSubUserServiceImpl : ServiceImpl<IWmSubUserMapper, WmSubUserEntity>(), IWmSubUserService
