@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.mapper;

import org.github.mysql.blog.base.entity.OperationLogEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 *  Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IOperationLogMapper : IMapper<OperationLogEntity>
