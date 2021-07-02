@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzFiredTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzFiredTriggersMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzFiredTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzFiredTriggersServiceImpl : ServiceImpl<IQuartzQrtzFiredTriggersMapper, QuartzQrtzFiredTriggersEntity>(), IQuartzQrtzFiredTriggersService
