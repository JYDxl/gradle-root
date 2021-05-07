package org.github.base.mapper;

import org.github.base.entity.ScheduleJobLogEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 定时任务日志 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@MyBatisMapper
public interface IScheduleJobLogMapper extends IMapper<ScheduleJobLogEntity> {}
