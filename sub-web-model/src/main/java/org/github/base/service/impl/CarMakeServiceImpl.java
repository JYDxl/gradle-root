package org.github.base.service.impl;

import org.github.base.entity.CarMakeEntity;
import org.github.base.mapper.ICarMakeMapper;
import org.github.base.service.ICarMakeService;
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
public class CarMakeServiceImpl extends ServiceImpl<ICarMakeMapper, CarMakeEntity> implements ICarMakeService {}
