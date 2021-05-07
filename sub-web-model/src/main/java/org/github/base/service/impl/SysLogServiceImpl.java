package org.github.base.service.impl;

import org.github.base.entity.SysLogEntity;
import org.github.base.mapper.ISysLogMapper;
import org.github.base.service.ISysLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<ISysLogMapper, SysLogEntity> implements ISysLogService {}
