package org.github.base.service.impl

import org.github.base.entity.SysLogininforEntity
import org.github.base.mapper.ISysLogininforMapper
import org.github.base.service.ISysLogininforService
import org.github.base.ServiceImpl
import org.springframework.stereotype.Service

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@Service
class SysLogininforServiceImpl: ServiceImpl<ISysLogininforMapper, SysLogininforEntity>(), ISysLogininforService
