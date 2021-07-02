@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzSimpleTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzSimpleTriggersMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzSimpleTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzSimpleTriggersServiceImpl : ServiceImpl<IMigrationQrtzSimpleTriggersMapper, MigrationQrtzSimpleTriggersEntity>(), IMigrationQrtzSimpleTriggersService
