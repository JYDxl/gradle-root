@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.AclAdminEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAclAdminMapper : IMapper<AclAdminEntity>
