package org.github.base.service.impl;

import org.github.base.entity.CarParamsEntity;
import org.github.base.mapper.ICarParamsMapper;
import org.github.base.service.ICarParamsService;
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
public class CarParamsServiceImpl extends ServiceImpl<ICarParamsMapper, CarParamsEntity> implements ICarParamsService {}
