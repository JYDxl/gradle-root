package org.github.base.service.impl;

import org.github.base.entity.ProductCarEntity;
import org.github.base.mapper.IProductCarMapper;
import org.github.base.service.IProductCarService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class ProductCarServiceImpl extends ServiceImpl<IProductCarMapper, ProductCarEntity> implements IProductCarService {}
