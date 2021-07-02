@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzCalendarsEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzCalendarsMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzCalendarsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzCalendarsServiceImpl : ServiceImpl<IMigrationQrtzCalendarsMapper, MigrationQrtzCalendarsEntity>(), IMigrationQrtzCalendarsService
