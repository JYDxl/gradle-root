@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SpAttributeEntity;
import org.github.mysql.mydb.base.mapper.ISpAttributeMapper;
import org.github.mysql.mydb.base.service.ISpAttributeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 属性表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SpAttributeServiceImpl : ServiceImpl<ISpAttributeMapper, SpAttributeEntity>(), ISpAttributeService
