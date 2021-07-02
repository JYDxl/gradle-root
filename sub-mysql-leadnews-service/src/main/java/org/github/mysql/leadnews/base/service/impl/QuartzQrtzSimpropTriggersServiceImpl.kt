@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzSimpropTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzSimpropTriggersMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzSimpropTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzSimpropTriggersServiceImpl : ServiceImpl<IQuartzQrtzSimpropTriggersMapper, QuartzQrtzSimpropTriggersEntity>(), IQuartzQrtzSimpropTriggersService
