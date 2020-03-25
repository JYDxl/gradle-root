package org.github.base.mapper;

import org.github.base.entity.SysDeptEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@MyBatisMapper
public interface ISysDeptMapper extends IMapper<SysDeptEntity> {}