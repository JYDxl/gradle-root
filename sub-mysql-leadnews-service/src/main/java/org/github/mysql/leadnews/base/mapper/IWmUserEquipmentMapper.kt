@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.WmUserEquipmentEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 自媒体用户设备信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IWmUserEquipmentMapper : IMapper<WmUserEquipmentEntity>
