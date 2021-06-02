@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysRoleMenuEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色与菜单对应关系 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysRoleMenuMapper : IMapper<SysRoleMenuEntity>
