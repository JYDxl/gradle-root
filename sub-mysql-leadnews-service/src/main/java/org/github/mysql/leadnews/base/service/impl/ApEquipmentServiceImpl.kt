@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApEquipmentEntity;
import org.github.mysql.leadnews.base.mapper.IApEquipmentMapper;
import org.github.mysql.leadnews.base.service.IApEquipmentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP设备信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApEquipmentServiceImpl : ServiceImpl<IApEquipmentMapper, ApEquipmentEntity>(), IApEquipmentService
