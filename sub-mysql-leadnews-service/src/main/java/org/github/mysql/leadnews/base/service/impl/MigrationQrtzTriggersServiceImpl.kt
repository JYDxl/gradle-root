@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzTriggersMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzTriggersServiceImpl : ServiceImpl<IMigrationQrtzTriggersMapper, MigrationQrtzTriggersEntity>(), IMigrationQrtzTriggersService
