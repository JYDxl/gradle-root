@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysDictItemEntity;
import org.github.mysql.sccore.base.mapper.ISysDictItemMapper;
import org.github.mysql.sccore.base.service.ISysDictItemService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值条目 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictItemServiceImpl : ServiceImpl<ISysDictItemMapper, SysDictItemEntity>(), ISysDictItemService
