@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.HseHouseBrokerEntity;
import org.github.mysql.web.base.mapper.IHseHouseBrokerMapper;
import org.github.mysql.web.base.service.IHseHouseBrokerService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 房源经纪人 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class HseHouseBrokerServiceImpl : ServiceImpl<IHseHouseBrokerMapper, HseHouseBrokerEntity>(), IHseHouseBrokerService
