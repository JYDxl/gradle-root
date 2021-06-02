@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysMenuEntity;
import org.github.mysql.web.base.mapper.ISysMenuMapper;
import org.github.mysql.web.base.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysMenuServiceImpl : ServiceImpl<ISysMenuMapper, SysMenuEntity>(), ISysMenuService
