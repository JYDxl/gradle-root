@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClIpPoolEntity;
import org.github.mysql.leadnews.base.mapper.IClIpPoolMapper;
import org.github.mysql.leadnews.base.service.IClIpPoolService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClIpPoolServiceImpl : ServiceImpl<IClIpPoolMapper, ClIpPoolEntity>(), IClIpPoolService
