@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmUserEquipmentEntity;
import org.github.mysql.leadnews.base.mapper.IWmUserEquipmentMapper;
import org.github.mysql.leadnews.base.service.IWmUserEquipmentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体用户设备信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmUserEquipmentServiceImpl : ServiceImpl<IWmUserEquipmentMapper, WmUserEquipmentEntity>(), IWmUserEquipmentService
