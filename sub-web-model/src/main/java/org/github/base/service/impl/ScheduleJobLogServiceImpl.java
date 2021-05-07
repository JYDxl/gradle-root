package org.github.base.service.impl;

import org.github.base.entity.ScheduleJobLogEntity;
import org.github.base.mapper.IScheduleJobLogMapper;
import org.github.base.service.IScheduleJobLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务日志 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class ScheduleJobLogServiceImpl extends ServiceImpl<IScheduleJobLogMapper, ScheduleJobLogEntity> implements IScheduleJobLogService {}
