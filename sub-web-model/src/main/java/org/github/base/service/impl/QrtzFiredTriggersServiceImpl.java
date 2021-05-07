package org.github.base.service.impl;

import org.github.base.entity.QrtzFiredTriggersEntity;
import org.github.base.mapper.IQrtzFiredTriggersMapper;
import org.github.base.service.IQrtzFiredTriggersService;
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
public class QrtzFiredTriggersServiceImpl extends ServiceImpl<IQrtzFiredTriggersMapper, QrtzFiredTriggersEntity> implements IQrtzFiredTriggersService {}
