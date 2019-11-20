package org.github.base.mapper

import org.github.base.IMapper
import org.github.base.entity.QrtzLocksEntity
import org.github.mybatis.MyBatisMapper

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@MyBatisMapper
interface IQrtzLocksMapper: IMapper<QrtzLocksEntity>
