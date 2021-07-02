@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzCronTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzCronTriggersMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzCronTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzCronTriggersServiceImpl : ServiceImpl<IQuartzQrtzCronTriggersMapper, QuartzQrtzCronTriggersEntity>(), IQuartzQrtzCronTriggersService
