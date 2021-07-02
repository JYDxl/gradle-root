@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClTaskEntity;
import org.github.mysql.leadnews.base.mapper.IClTaskMapper;
import org.github.mysql.leadnews.base.service.IClTaskService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬虫任务信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClTaskServiceImpl : ServiceImpl<IClTaskMapper, ClTaskEntity>(), IClTaskService
