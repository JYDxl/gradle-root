package org.github.base.service.impl;

import org.github.base.entity.QrtzTriggersEntity;
import org.github.base.mapper.IQrtzTriggersMapper;
import org.github.base.service.IQrtzTriggersService;
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
public class QrtzTriggersServiceImpl extends ServiceImpl<IQrtzTriggersMapper, QrtzTriggersEntity> implements IQrtzTriggersService {}
