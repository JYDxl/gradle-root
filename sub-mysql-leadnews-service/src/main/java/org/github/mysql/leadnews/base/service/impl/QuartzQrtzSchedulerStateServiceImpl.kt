@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzSchedulerStateEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzSchedulerStateMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzSchedulerStateService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzSchedulerStateServiceImpl : ServiceImpl<IQuartzQrtzSchedulerStateMapper, QuartzQrtzSchedulerStateEntity>(), IQuartzQrtzSchedulerStateService
