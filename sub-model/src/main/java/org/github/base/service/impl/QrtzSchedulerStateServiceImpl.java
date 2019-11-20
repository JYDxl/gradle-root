package org.github.base.service.impl;

import org.github.base.entity.QrtzSchedulerStateEntity;
import org.github.base.mapper.IQrtzSchedulerStateMapper;
import org.github.base.service.IQrtzSchedulerStateService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@Service
public class QrtzSchedulerStateServiceImpl extends ServiceImpl<IQrtzSchedulerStateMapper, QrtzSchedulerStateEntity> implements IQrtzSchedulerStateService {}
