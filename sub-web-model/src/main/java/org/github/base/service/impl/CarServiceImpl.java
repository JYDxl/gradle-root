package org.github.base.service.impl;

import org.github.base.entity.CarEntity;
import org.github.base.mapper.ICarMapper;
import org.github.base.service.ICarService;
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
public class CarServiceImpl extends ServiceImpl<ICarMapper, CarEntity> implements ICarService {}
