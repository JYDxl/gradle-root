package org.github.base.service.impl;

import org.github.base.entity.QrtzCronTriggersEntity;
import org.github.base.mapper.IQrtzCronTriggersMapper;
import org.github.base.service.IQrtzCronTriggersService;
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
public class QrtzCronTriggersServiceImpl extends ServiceImpl<IQrtzCronTriggersMapper, QrtzCronTriggersEntity> implements IQrtzCronTriggersService {}
