package org.github.base.service.impl

import org.github.base.entity.SysJobEntity
import org.github.base.mapper.ISysJobMapper
import org.github.base.service.ISysJobService
import org.github.base.ServiceImpl
import org.springframework.stereotype.Service

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@Service
class SysJobServiceImpl: ServiceImpl<ISysJobMapper, SysJobEntity>(), ISysJobService
