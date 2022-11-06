@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysDepartmentEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 部门表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysDepartmentMapper : IMapper<SysDepartmentEntity>
