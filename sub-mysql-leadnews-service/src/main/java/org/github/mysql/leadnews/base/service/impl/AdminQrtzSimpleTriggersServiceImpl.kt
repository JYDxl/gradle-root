@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzSimpleTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzSimpleTriggersMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzSimpleTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzSimpleTriggersServiceImpl : ServiceImpl<IAdminQrtzSimpleTriggersMapper, AdminQrtzSimpleTriggersEntity>(), IAdminQrtzSimpleTriggersService
