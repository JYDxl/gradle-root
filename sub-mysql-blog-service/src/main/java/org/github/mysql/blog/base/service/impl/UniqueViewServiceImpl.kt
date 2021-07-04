@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.UniqueViewEntity;
import org.github.mysql.blog.base.mapper.IUniqueViewMapper;
import org.github.mysql.blog.base.service.IUniqueViewService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UniqueViewServiceImpl : ServiceImpl<IUniqueViewMapper, UniqueViewEntity>(), IUniqueViewService
