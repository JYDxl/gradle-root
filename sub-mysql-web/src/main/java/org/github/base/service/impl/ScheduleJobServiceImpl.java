package org.github.base.service.impl;

import org.github.base.entity.ScheduleJobEntity;
import org.github.base.mapper.IScheduleJobMapper;
import org.github.base.service.IScheduleJobService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<IScheduleJobMapper, ScheduleJobEntity> implements IScheduleJobService {}
