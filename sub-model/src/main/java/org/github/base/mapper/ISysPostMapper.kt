package org.github.base.mapper

import org.github.base.IMapper
import org.github.base.entity.SysPostEntity
import org.github.mybatis.MyBatisMapper

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@MyBatisMapper
interface ISysPostMapper: IMapper<SysPostEntity>
