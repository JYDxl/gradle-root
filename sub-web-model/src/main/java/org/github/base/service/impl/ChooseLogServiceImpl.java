package org.github.base.service.impl;

import org.github.base.entity.ChooseLogEntity;
import org.github.base.mapper.IChooseLogMapper;
import org.github.base.service.IChooseLogService;
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
public class ChooseLogServiceImpl extends ServiceImpl<IChooseLogMapper, ChooseLogEntity> implements IChooseLogService {}
