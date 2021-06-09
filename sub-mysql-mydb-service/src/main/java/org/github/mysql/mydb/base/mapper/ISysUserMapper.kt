@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysUserMapper : IMapper<SysUserEntity>
