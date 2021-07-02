@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzPausedTriggerGrpsEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzPausedTriggerGrpsMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzPausedTriggerGrpsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzPausedTriggerGrpsServiceImpl : ServiceImpl<IQuartzQrtzPausedTriggerGrpsMapper, QuartzQrtzPausedTriggerGrpsEntity>(), IQuartzQrtzPausedTriggerGrpsService
