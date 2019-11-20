package org.github.base.mapper

import org.github.base.IMapper
import org.github.base.entity.SysDictDataEntity
import org.github.mybatis.MyBatisMapper

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@MyBatisMapper
interface ISysDictDataMapper: IMapper<SysDictDataEntity>
