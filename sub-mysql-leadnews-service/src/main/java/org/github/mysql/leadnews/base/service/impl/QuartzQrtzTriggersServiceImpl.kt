@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzTriggersMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzTriggersServiceImpl : ServiceImpl<IQuartzQrtzTriggersMapper, QuartzQrtzTriggersEntity>(), IQuartzQrtzTriggersService
