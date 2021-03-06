package org.github.base.service.impl;

import org.github.base.entity.SysJobLogEntity;
import org.github.base.mapper.ISysJobLogMapper;
import org.github.base.service.ISysJobLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<ISysJobLogMapper, SysJobLogEntity> implements ISysJobLogService {}
