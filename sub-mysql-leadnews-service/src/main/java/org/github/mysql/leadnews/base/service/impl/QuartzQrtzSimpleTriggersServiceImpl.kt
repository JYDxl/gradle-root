@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzSimpleTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzSimpleTriggersMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzSimpleTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzSimpleTriggersServiceImpl : ServiceImpl<IQuartzQrtzSimpleTriggersMapper, QuartzQrtzSimpleTriggersEntity>(), IQuartzQrtzSimpleTriggersService
