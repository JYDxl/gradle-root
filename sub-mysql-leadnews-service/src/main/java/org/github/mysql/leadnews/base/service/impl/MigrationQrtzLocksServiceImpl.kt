@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzLocksEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzLocksMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzLocksService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzLocksServiceImpl : ServiceImpl<IMigrationQrtzLocksMapper, MigrationQrtzLocksEntity>(), IMigrationQrtzLocksService
