@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysClientAuthEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 客户端授权表，登录授权、API授权、文件服务授权、调度授权 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysClientAuthMapper : IMapper<SysClientAuthEntity>
