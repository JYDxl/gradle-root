@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.HseHouseEntity;
import org.github.mysql.web.base.mapper.IHseHouseMapper;
import org.github.mysql.web.base.service.IHseHouseService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 房源表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class HseHouseService : ServiceImpl<IHseHouseMapper, HseHouseEntity>(), IHseHouseService
