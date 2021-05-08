package org.github.base.service.impl;

import org.github.base.entity.VisitLogEntity;
import org.github.base.mapper.IVisitLogMapper;
import org.github.base.service.IVisitLogService;
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
public class VisitLogServiceImpl extends ServiceImpl<IVisitLogMapper, VisitLogEntity> implements IVisitLogService {}
