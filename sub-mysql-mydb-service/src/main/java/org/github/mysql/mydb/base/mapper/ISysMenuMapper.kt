@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysMenuEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 菜单表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysMenuMapper : IMapper<SysMenuEntity>
