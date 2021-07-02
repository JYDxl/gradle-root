@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzSchedulerStateEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzSchedulerStateMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzSchedulerStateService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzSchedulerStateServiceImpl : ServiceImpl<IMigrationQrtzSchedulerStateMapper, MigrationQrtzSchedulerStateEntity>(), IMigrationQrtzSchedulerStateService
