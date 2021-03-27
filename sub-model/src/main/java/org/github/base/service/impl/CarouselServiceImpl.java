package org.github.base.service.impl;

import org.github.base.entity.CarouselEntity;
import org.github.base.mapper.ICarouselMapper;
import org.github.base.service.ICarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 轮播图  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<ICarouselMapper, CarouselEntity> implements ICarouselService {}
