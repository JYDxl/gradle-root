package org.github.base.mapper;

import org.github.base.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 商品分类  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@MyBatisMapper
public interface ICategoryMapper extends BaseMapper<CategoryEntity> {}
