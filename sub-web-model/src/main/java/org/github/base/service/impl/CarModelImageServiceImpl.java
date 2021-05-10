package org.github.base.service.impl;

import org.github.base.entity.CarModelImageEntity;
import org.github.base.mapper.ICarModelImageMapper;
import org.github.base.service.ICarModelImageService;
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
public class CarModelImageServiceImpl extends ServiceImpl<ICarModelImageMapper, CarModelImageEntity> implements ICarModelImageService {}