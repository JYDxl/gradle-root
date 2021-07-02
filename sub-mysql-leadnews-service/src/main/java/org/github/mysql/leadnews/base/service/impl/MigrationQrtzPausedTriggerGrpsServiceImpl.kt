@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzPausedTriggerGrpsEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzPausedTriggerGrpsMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzPausedTriggerGrpsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzPausedTriggerGrpsServiceImpl : ServiceImpl<IMigrationQrtzPausedTriggerGrpsMapper, MigrationQrtzPausedTriggerGrpsEntity>(), IMigrationQrtzPausedTriggerGrpsService
