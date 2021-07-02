@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzBlobTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzBlobTriggersMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzBlobTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzBlobTriggersServiceImpl : ServiceImpl<IAdminQrtzBlobTriggersMapper, AdminQrtzBlobTriggersEntity>(), IAdminQrtzBlobTriggersService
