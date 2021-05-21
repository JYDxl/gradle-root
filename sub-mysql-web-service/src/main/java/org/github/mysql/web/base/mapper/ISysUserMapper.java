package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@MyBatisMapper
public interface ISysUserMapper extends IMapper<SysUserEntity> {}
