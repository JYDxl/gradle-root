@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzCalendarsEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzCalendarsMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzCalendarsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzCalendarsServiceImpl : ServiceImpl<IAdminQrtzCalendarsMapper, AdminQrtzCalendarsEntity>(), IAdminQrtzCalendarsService
