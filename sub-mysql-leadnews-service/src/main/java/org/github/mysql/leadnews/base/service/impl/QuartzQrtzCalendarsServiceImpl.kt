@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzCalendarsEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzCalendarsMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzCalendarsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzCalendarsServiceImpl : ServiceImpl<IQuartzQrtzCalendarsMapper, QuartzQrtzCalendarsEntity>(), IQuartzQrtzCalendarsService
