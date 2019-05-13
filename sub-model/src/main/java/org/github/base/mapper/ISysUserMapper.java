package org.github.base.mapper;

import org.github.base.entity.SysUserEntity;
import org.github.mybatis.MyBatisMapper;
import org.github.base.IMapper;

/**
 * <p>
 * 系统-用户表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-05-12
 */
@MyBatisMapper
public interface ISysUserMapper extends IMapper<SysUserEntity> {}
