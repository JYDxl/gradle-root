@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzTriggersMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzTriggersServiceImpl : ServiceImpl<IAdminQrtzTriggersMapper, AdminQrtzTriggersEntity>(), IAdminQrtzTriggersService
