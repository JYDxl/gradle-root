@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.OperationLogEntity;
import org.github.mysql.blog.base.mapper.IOperationLogMapper;
import org.github.mysql.blog.base.service.IOperationLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class OperationLogServiceImpl : ServiceImpl<IOperationLogMapper, OperationLogEntity>(), IOperationLogService
