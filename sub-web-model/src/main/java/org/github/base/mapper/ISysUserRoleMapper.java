package org.github.base.mapper;

import org.github.base.entity.SysUserRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 用户与角色对应关系 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@MyBatisMapper
public interface ISysUserRoleMapper extends IMapper<SysUserRoleEntity> {}
