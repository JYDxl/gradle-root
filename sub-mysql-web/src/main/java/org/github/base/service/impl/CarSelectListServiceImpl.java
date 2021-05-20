package org.github.base.service.impl;

import org.github.base.entity.CarSelectListEntity;
import org.github.base.mapper.ICarSelectListMapper;
import org.github.base.service.ICarSelectListService;
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
public class CarSelectListServiceImpl extends ServiceImpl<ICarSelectListMapper, CarSelectListEntity> implements ICarSelectListService {}
