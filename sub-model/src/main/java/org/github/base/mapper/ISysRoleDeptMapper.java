package org.github.base.mapper;

import org.github.base.entity.SysRoleDeptEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 角色和部门关联表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@MyBatisMapper
public interface ISysRoleDeptMapper extends IMapper<SysRoleDeptEntity> {}
