package org.github.base.service.impl;

import org.github.base.entity.CarModelEntity;
import org.github.base.mapper.ICarModelMapper;
import org.github.base.service.ICarModelService;
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
public class CarModelServiceImpl extends ServiceImpl<ICarModelMapper, CarModelEntity> implements ICarModelService {}
