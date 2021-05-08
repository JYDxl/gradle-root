package org.github.base.service.impl;

import org.github.base.entity.DictModelEntity;
import org.github.base.mapper.IDictModelMapper;
import org.github.base.service.IDictModelService;
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
public class DictModelServiceImpl extends ServiceImpl<IDictModelMapper, DictModelEntity> implements IDictModelService {}
