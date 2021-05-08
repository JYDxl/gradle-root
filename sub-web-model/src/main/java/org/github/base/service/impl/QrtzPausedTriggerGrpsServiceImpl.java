package org.github.base.service.impl;

import org.github.base.entity.QrtzPausedTriggerGrpsEntity;
import org.github.base.mapper.IQrtzPausedTriggerGrpsMapper;
import org.github.base.service.IQrtzPausedTriggerGrpsService;
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
public class QrtzPausedTriggerGrpsServiceImpl extends ServiceImpl<IQrtzPausedTriggerGrpsMapper, QrtzPausedTriggerGrpsEntity> implements IQrtzPausedTriggerGrpsService {}
