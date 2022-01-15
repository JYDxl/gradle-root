@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.LogEntity;
import org.github.mysql.mydb.base.mapper.ILogMapper;
import org.github.mysql.mydb.base.service.ILogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class LogServiceImpl : ServiceImpl<ILogMapper, LogEntity>(), ILogService
