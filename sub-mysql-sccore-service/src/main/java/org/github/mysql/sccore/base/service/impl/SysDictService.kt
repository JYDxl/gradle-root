@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysDictEntity;
import org.github.mysql.sccore.base.mapper.ISysDictMapper;
import org.github.mysql.sccore.base.service.ISysDictService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值类型 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDictService : ServiceImpl<ISysDictMapper, SysDictEntity>(), ISysDictService
