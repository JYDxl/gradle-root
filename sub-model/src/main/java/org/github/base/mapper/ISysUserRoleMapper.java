package org.github.base.mapper;

import org.github.base.entity.SysUserRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@MyBatisMapper
public interface ISysUserRoleMapper extends IMapper<SysUserRoleEntity> {}
