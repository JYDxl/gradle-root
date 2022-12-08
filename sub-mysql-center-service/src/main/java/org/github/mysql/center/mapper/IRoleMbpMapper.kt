@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.mapper;

import org.github.mysql.center.entity.RoleMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 角色 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IRoleMbpMapper : IMapper<RoleMbpPo>
