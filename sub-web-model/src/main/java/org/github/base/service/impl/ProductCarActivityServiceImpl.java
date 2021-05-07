package org.github.base.service.impl;

import org.github.base.entity.ProductCarActivityEntity;
import org.github.base.mapper.IProductCarActivityMapper;
import org.github.base.service.IProductCarActivityService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class ProductCarActivityServiceImpl extends ServiceImpl<IProductCarActivityMapper, ProductCarActivityEntity> implements IProductCarActivityService {}
