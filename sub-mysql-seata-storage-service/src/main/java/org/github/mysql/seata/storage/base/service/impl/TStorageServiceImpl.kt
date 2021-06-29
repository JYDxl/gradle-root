@file:Suppress("RedundantSemicolon")

package org.github.mysql.seata.storage.base.service.impl;

import org.github.mysql.seata.storage.base.entity.TStorageEntity;
import org.github.mysql.seata.storage.base.mapper.ITStorageMapper;
import org.github.mysql.seata.storage.base.service.ITStorageService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 库存表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TStorageServiceImpl : ServiceImpl<ITStorageMapper, TStorageEntity>(), ITStorageService
