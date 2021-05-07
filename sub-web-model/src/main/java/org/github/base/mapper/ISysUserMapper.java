package org.github.base.mapper;

import org.github.base.entity.SysUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@MyBatisMapper
public interface ISysUserMapper extends IMapper<SysUserEntity> {}
