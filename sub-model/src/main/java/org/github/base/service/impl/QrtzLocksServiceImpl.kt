package org.github.base.service.impl

import org.github.base.entity.QrtzLocksEntity
import org.github.base.mapper.IQrtzLocksMapper
import org.github.base.service.IQrtzLocksService
import org.github.base.ServiceImpl
import org.springframework.stereotype.Service

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@Service
class QrtzLocksServiceImpl: ServiceImpl<IQrtzLocksMapper, QrtzLocksEntity>(), IQrtzLocksService
