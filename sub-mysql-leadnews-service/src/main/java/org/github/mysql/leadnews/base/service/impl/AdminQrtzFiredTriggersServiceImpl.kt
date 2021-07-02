@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzFiredTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzFiredTriggersMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzFiredTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzFiredTriggersServiceImpl : ServiceImpl<IAdminQrtzFiredTriggersMapper, AdminQrtzFiredTriggersEntity>(), IAdminQrtzFiredTriggersService
