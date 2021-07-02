@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClTaskExceptionEntity;
import org.github.mysql.leadnews.base.mapper.IClTaskExceptionMapper;
import org.github.mysql.leadnews.base.service.IClTaskExceptionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬取异常信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClTaskExceptionServiceImpl : ServiceImpl<IClTaskExceptionMapper, ClTaskExceptionEntity>(), IClTaskExceptionService
