@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysDictEntity;
import org.github.mysql.mydb.base.mapper.ISysDictMapper;
import org.github.mysql.mydb.base.service.ISysDictService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 字典总表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictServiceImpl : ServiceImpl<ISysDictMapper, SysDictEntity>(), ISysDictService
