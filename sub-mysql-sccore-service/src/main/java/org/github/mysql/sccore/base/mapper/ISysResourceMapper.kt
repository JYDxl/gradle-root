@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysResourceEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 资源接口管理 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysResourceMapper : IMapper<SysResourceEntity>
