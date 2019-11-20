package org.github.base.service.impl

import org.github.base.entity.SysDictTypeEntity
import org.github.base.mapper.ISysDictTypeMapper
import org.github.base.service.ISysDictTypeService
import org.github.base.ServiceImpl
import org.springframework.stereotype.Service

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@Service
class SysDictTypeServiceImpl: ServiceImpl<ISysDictTypeMapper, SysDictTypeEntity>(), ISysDictTypeService
