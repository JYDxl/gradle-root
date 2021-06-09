@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysRoleMenuEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色-菜单关系表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysRoleMenuMapper : IMapper<SysRoleMenuEntity>
