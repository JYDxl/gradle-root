package org.github.base.mapper;

import org.github.base.entity.ScheduleJobEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 定时任务 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@MyBatisMapper
public interface IScheduleJobMapper extends IMapper<ScheduleJobEntity> {}