@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzCronTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzCronTriggersMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzCronTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzCronTriggersServiceImpl : ServiceImpl<IAdminQrtzCronTriggersMapper, AdminQrtzCronTriggersEntity>(), IAdminQrtzCronTriggersService
