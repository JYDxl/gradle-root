@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.SysDictMbpPo;
import org.github.mysql.center.mapper.ISysDictMbpMapper;
import org.github.mysql.center.service.ISysDictMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值类型 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictMbpService : ServiceImpl<ISysDictMbpMapper, SysDictMbpPo>(), ISysDictMbpService
