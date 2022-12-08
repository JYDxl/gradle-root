@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.mapper;

import org.github.mysql.center.entity.SmsMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 短信验证码 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISmsMbpMapper : IMapper<SmsMbpPo>
