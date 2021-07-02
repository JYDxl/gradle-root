@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzSimpropTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzSimpropTriggersMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzSimpropTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzSimpropTriggersServiceImpl : ServiceImpl<IAdminQrtzSimpropTriggersMapper, AdminQrtzSimpropTriggersEntity>(), IAdminQrtzSimpropTriggersService
