package org.github.base.mapper;

import org.github.base.entity.SysOperLogEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@MyBatisMapper
public interface ISysOperLogMapper extends IMapper<SysOperLogEntity> {}
