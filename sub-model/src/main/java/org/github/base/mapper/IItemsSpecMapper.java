package org.github.base.mapper;

import org.github.base.entity.ItemsSpecEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@MyBatisMapper
public interface IItemsSpecMapper extends BaseMapper<ItemsSpecEntity> {}
