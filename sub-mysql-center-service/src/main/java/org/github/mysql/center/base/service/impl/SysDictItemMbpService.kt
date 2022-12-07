@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SysDictItemMbpEntity;
import org.github.mysql.center.base.mapper.ISysDictItemMbpMapper;
import org.github.mysql.center.base.service.ISysDictItemMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值条目 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictItemMbpService : ServiceImpl<ISysDictItemMbpMapper, SysDictItemMbpEntity>(), ISysDictItemMbpService
