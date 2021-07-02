@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.MigrationQrtzJobDetailsEntity;
import org.github.mysql.leadnews.base.mapper.IMigrationQrtzJobDetailsMapper;
import org.github.mysql.leadnews.base.service.IMigrationQrtzJobDetailsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MigrationQrtzJobDetailsServiceImpl : ServiceImpl<IMigrationQrtzJobDetailsMapper, MigrationQrtzJobDetailsEntity>(), IMigrationQrtzJobDetailsService
