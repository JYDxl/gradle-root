@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.MenuEntity;
import org.github.mysql.blog.base.mapper.IMenuMapper;
import org.github.mysql.blog.base.service.IMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MenuServiceImpl : ServiceImpl<IMenuMapper, MenuEntity>(), IMenuService
