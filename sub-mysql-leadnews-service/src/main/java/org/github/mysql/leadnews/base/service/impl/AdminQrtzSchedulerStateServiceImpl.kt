@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzSchedulerStateEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzSchedulerStateMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzSchedulerStateService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzSchedulerStateServiceImpl : ServiceImpl<IAdminQrtzSchedulerStateMapper, AdminQrtzSchedulerStateEntity>(), IAdminQrtzSchedulerStateService
