package org.github.base.mapper;

import org.github.base.entity.TbUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@MyBatisMapper
public interface ITbUserMapper extends IMapper<TbUserEntity> {}
