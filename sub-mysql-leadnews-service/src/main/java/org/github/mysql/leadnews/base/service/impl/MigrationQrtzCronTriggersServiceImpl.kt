@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzCronTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzCronTriggersMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzCronTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzCronTriggersServiceImpl : ServiceImpl<IMigrationQrtzCronTriggersMapper, MigrationQrtzCronTriggersEntity>(), IMigrationQrtzCronTriggersService
