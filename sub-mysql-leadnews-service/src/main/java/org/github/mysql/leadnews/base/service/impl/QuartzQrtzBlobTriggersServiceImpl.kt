@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.QuartzQrtzBlobTriggersEntity;
import org.github.mysql.leadnews.base.mapper.IQuartzQrtzBlobTriggersMapper;
import org.github.mysql.leadnews.base.service.IQuartzQrtzBlobTriggersService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class QuartzQrtzBlobTriggersServiceImpl : ServiceImpl<IQuartzQrtzBlobTriggersMapper, QuartzQrtzBlobTriggersEntity>(), IQuartzQrtzBlobTriggersService
