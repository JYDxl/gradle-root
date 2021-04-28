package org.github.base.service.impl;

import org.github.base.entity.TbFunctionsEntity;
import org.github.base.mapper.ITbFunctionsMapper;
import org.github.base.service.ITbFunctionsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-21
 */
@Service
public class TbFunctionsServiceImpl extends ServiceImpl<ITbFunctionsMapper, TbFunctionsEntity> implements ITbFunctionsService {}
