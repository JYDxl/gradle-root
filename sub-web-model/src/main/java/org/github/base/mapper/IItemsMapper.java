package org.github.base.mapper;

import org.github.base.entity.ItemsEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@MyBatisMapper
public interface IItemsMapper extends IMapper<ItemsEntity> {}
