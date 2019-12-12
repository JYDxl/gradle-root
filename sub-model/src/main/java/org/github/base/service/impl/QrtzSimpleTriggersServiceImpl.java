package org.github.base.service.impl;

import org.github.base.entity.QrtzSimpleTriggersEntity;
import org.github.base.mapper.IQrtzSimpleTriggersMapper;
import org.github.base.service.IQrtzSimpleTriggersService;
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
public class QrtzSimpleTriggersServiceImpl extends ServiceImpl<IQrtzSimpleTriggersMapper, QrtzSimpleTriggersEntity> implements IQrtzSimpleTriggersService {}
