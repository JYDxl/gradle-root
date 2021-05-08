package org.github.base.service.impl;

import org.github.base.entity.ProductEntity;
import org.github.base.mapper.IProductMapper;
import org.github.base.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<IProductMapper, ProductEntity> implements IProductService {}
