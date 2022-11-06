@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysRoleMenuRelaEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色菜单管理 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysRoleMenuRelaMapper : IMapper<SysRoleMenuRelaEntity>
