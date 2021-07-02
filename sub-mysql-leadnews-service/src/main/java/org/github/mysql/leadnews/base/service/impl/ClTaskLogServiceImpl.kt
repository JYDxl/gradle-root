@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClTaskLogEntity;
import org.github.mysql.leadnews.base.mapper.IClTaskLogMapper;
import org.github.mysql.leadnews.base.service.IClTaskLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬取日志表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClTaskLogServiceImpl : ServiceImpl<IClTaskLogMapper, ClTaskLogEntity>(), IClTaskLogService
