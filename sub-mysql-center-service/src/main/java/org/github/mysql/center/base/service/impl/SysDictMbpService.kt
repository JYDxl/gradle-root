@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SysDictMbpEntity;
import org.github.mysql.center.base.mapper.ISysDictMbpMapper;
import org.github.mysql.center.base.service.ISysDictMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值类型 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictMbpService : ServiceImpl<ISysDictMbpMapper, SysDictMbpEntity>(), ISysDictMbpService
