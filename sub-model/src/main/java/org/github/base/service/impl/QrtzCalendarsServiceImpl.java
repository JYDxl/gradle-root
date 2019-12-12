package org.github.base.service.impl;

import org.github.base.entity.QrtzCalendarsEntity;
import org.github.base.mapper.IQrtzCalendarsMapper;
import org.github.base.service.IQrtzCalendarsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class QrtzCalendarsServiceImpl extends ServiceImpl<IQrtzCalendarsMapper, QrtzCalendarsEntity> implements IQrtzCalendarsService {}
