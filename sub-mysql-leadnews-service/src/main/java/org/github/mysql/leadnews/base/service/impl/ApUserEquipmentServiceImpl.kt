@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserEquipmentEntity;
import org.github.mysql.leadnews.base.mapper.IApUserEquipmentMapper;
import org.github.mysql.leadnews.base.service.IApUserEquipmentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户设备信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserEquipmentServiceImpl : ServiceImpl<IApUserEquipmentMapper, ApUserEquipmentEntity>(), IApUserEquipmentService
