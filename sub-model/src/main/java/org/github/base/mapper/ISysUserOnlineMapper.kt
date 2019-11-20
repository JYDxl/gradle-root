package org.github.base.mapper

import org.github.base.IMapper
import org.github.base.entity.SysUserOnlineEntity
import org.github.mybatis.MyBatisMapper

/**
 * <p>
 * 在线用户记录 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@MyBatisMapper
interface ISysUserOnlineMapper: IMapper<SysUserOnlineEntity>
