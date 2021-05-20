package org.github.base.service.impl;

import org.github.base.entity.DictCountryEntity;
import org.github.base.mapper.IDictCountryMapper;
import org.github.base.service.IDictCountryService;
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
public class DictCountryServiceImpl extends ServiceImpl<IDictCountryMapper, DictCountryEntity> implements IDictCountryService {}
