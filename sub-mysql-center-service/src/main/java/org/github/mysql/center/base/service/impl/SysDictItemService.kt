@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SysDictItemEntity;
import org.github.mysql.center.base.mapper.ISysDictItemMapper;
import org.github.mysql.center.base.service.ISysDictItemService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值条目 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictItemService : ServiceImpl<ISysDictItemMapper, SysDictItemEntity>(), ISysDictItemService
