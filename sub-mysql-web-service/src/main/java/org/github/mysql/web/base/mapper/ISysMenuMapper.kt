@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysMenuEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 菜单管理 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysMenuMapper : IMapper<SysMenuEntity>
