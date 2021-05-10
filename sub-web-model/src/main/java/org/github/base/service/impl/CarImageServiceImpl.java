package org.github.base.service.impl;

import org.github.base.entity.CarImageEntity;
import org.github.base.mapper.ICarImageMapper;
import org.github.base.service.ICarImageService;
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
public class CarImageServiceImpl extends ServiceImpl<ICarImageMapper, CarImageEntity> implements ICarImageService {}