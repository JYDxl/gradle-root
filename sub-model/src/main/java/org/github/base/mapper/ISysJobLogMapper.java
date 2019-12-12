package org.github.base.mapper;

import org.github.base.entity.SysJobLogEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 定时任务调度日志表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@MyBatisMapper
public interface ISysJobLogMapper extends IMapper<SysJobLogEntity> {}
