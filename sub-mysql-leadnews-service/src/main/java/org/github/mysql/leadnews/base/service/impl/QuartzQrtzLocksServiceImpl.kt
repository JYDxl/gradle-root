@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzLocksEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzLocksMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzLocksService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzLocksServiceImpl : ServiceImpl<IQuartzQrtzLocksMapper, QuartzQrtzLocksEntity>(), IQuartzQrtzLocksService
