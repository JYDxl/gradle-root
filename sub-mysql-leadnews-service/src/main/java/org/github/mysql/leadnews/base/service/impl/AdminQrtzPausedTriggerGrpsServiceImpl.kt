@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzPausedTriggerGrpsEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzPausedTriggerGrpsMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzPausedTriggerGrpsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzPausedTriggerGrpsServiceImpl : ServiceImpl<IAdminQrtzPausedTriggerGrpsMapper, AdminQrtzPausedTriggerGrpsEntity>(), IAdminQrtzPausedTriggerGrpsService
