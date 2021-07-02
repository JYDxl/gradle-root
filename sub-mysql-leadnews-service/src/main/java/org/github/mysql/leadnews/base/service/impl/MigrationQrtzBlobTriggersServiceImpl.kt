@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzBlobTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzBlobTriggersMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzBlobTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzBlobTriggersServiceImpl : ServiceImpl<IMigrationQrtzBlobTriggersMapper, MigrationQrtzBlobTriggersEntity>(), IMigrationQrtzBlobTriggersService
