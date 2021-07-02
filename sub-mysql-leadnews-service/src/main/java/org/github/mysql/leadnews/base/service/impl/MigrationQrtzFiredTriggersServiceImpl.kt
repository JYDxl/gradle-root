@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzFiredTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzFiredTriggersMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzFiredTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzFiredTriggersServiceImpl : ServiceImpl<IMigrationQrtzFiredTriggersMapper, MigrationQrtzFiredTriggersEntity>(), IMigrationQrtzFiredTriggersService
