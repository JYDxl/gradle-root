@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzSimpropTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzSimpropTriggersMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzSimpropTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzSimpropTriggersServiceImpl : ServiceImpl<IMigrationQrtzSimpropTriggersMapper, MigrationQrtzSimpropTriggersEntity>(), IMigrationQrtzSimpropTriggersService
