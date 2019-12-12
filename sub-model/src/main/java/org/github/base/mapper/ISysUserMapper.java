package org.github.base.mapper;

import org.github.base.entity.SysUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@MyBatisMapper
public interface ISysUserMapper extends IMapper<SysUserEntity> {}
