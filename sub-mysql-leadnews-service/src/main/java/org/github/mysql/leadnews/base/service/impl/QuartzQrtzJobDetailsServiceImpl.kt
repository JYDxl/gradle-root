@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzJobDetailsEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzJobDetailsMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzJobDetailsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzJobDetailsServiceImpl : ServiceImpl<IQuartzQrtzJobDetailsMapper, QuartzQrtzJobDetailsEntity>(), IQuartzQrtzJobDetailsService
