@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysRoleRgRelaEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色-角色组关系 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysRoleRgRelaMapper : IMapper<SysRoleRgRelaEntity>
