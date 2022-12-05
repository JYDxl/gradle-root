@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.SmsMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 短信验证码 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISmsMbpMapper : IMapper<SmsMbpEntity>