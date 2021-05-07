package org.github.base.mapper;

import org.github.base.entity.SysConfigEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 系统配置信息表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@MyBatisMapper
public interface ISysConfigMapper extends IMapper<SysConfigEntity> {}
