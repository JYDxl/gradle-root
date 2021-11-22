@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysDictItemEntity;
import org.github.mysql.mydb.base.mapper.ISysDictItemMapper;
import org.github.mysql.mydb.base.service.ISysDictItemService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 字典明细表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictItemServiceImpl : ServiceImpl<ISysDictItemMapper, SysDictItemEntity>(), ISysDictItemService
