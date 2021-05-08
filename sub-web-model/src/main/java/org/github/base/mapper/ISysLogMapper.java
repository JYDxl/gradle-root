package org.github.base.mapper;

import org.github.base.entity.SysLogEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@MyBatisMapper
public interface ISysLogMapper extends IMapper<SysLogEntity> {}
