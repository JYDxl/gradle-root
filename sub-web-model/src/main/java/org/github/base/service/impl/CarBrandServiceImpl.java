package org.github.base.service.impl;

import org.github.base.entity.CarBrandEntity;
import org.github.base.mapper.ICarBrandMapper;
import org.github.base.service.ICarBrandService;
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
public class CarBrandServiceImpl extends ServiceImpl<ICarBrandMapper, CarBrandEntity> implements ICarBrandService {}
