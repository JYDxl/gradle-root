@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApEquipmentCodeEntity;
import org.github.mysql.leadnews.base.mapper.IApEquipmentCodeMapper;
import org.github.mysql.leadnews.base.service.IApEquipmentCodeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP设备码信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApEquipmentCodeServiceImpl : ServiceImpl<IApEquipmentCodeMapper, ApEquipmentCodeEntity>(), IApEquipmentCodeService
