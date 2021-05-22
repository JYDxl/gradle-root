package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysRoleMenuEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-22
 */
@MyBatisMapper
public interface ISysRoleMenuMapper extends IMapper<SysRoleMenuEntity> {}
