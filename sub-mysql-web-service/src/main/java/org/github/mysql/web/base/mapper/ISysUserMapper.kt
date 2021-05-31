@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 系统用户 Mapper 接口
 *
 * @author JYD_XL
 * @since 2021-05-31
 */
@MyBatisMapper
interface ISysUserMapper : IMapper<SysUserEntity>
