@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.SysDictItemMbpPo;
import org.github.mysql.center.mapper.ISysDictItemMbpMapper;
import org.github.mysql.center.service.ISysDictItemMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值条目 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictItemMbpService : ServiceImpl<ISysDictItemMbpMapper, SysDictItemMbpPo>(), ISysDictItemMbpService
