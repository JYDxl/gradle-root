@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdMenuEntity;
import org.github.mysql.leadnews.base.mapper.IAdMenuMapper;
import org.github.mysql.leadnews.base.service.IAdMenuService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单资源信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdMenuServiceImpl : ServiceImpl<IAdMenuMapper, AdMenuEntity>(), IAdMenuService
