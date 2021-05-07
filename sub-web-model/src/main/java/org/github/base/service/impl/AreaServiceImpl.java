package org.github.base.service.impl;

import org.github.base.entity.AreaEntity;
import org.github.base.mapper.IAreaMapper;
import org.github.base.service.IAreaService;
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
public class AreaServiceImpl extends ServiceImpl<IAreaMapper, AreaEntity> implements IAreaService {}
