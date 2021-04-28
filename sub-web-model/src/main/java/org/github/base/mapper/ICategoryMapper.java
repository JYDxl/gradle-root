package org.github.base.mapper;

import org.github.base.entity.CategoryEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 商品分类  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@MyBatisMapper
public interface ICategoryMapper extends IMapper<CategoryEntity> {}
