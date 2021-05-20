package org.github.base.service.impl;

import org.github.base.entity.CarManufacturerEntity;
import org.github.base.mapper.ICarManufacturerMapper;
import org.github.base.service.ICarManufacturerService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class CarManufacturerServiceImpl extends ServiceImpl<ICarManufacturerMapper, CarManufacturerEntity> implements ICarManufacturerService {}
