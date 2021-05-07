package org.github.base.service.impl;

import org.github.base.entity.OperateLogEntity;
import org.github.base.mapper.IOperateLogMapper;
import org.github.base.service.IOperateLogService;
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
public class OperateLogServiceImpl extends ServiceImpl<IOperateLogMapper, OperateLogEntity> implements IOperateLogService {}
