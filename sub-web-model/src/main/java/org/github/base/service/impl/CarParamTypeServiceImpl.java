package org.github.base.service.impl;

import org.github.base.entity.CarParamTypeEntity;
import org.github.base.mapper.ICarParamTypeMapper;
import org.github.base.service.ICarParamTypeService;
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
public class CarParamTypeServiceImpl extends ServiceImpl<ICarParamTypeMapper, CarParamTypeEntity> implements ICarParamTypeService {}
