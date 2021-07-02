@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdUserEquipmentEntity;
import org.github.mysql.leadnews.base.mapper.IAdUserEquipmentMapper;
import org.github.mysql.leadnews.base.service.IAdUserEquipmentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 管理员设备信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdUserEquipmentServiceImpl : ServiceImpl<IAdUserEquipmentMapper, AdUserEquipmentEntity>(), IAdUserEquipmentService
