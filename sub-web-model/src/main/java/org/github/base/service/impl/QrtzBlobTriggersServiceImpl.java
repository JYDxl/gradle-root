package org.github.base.service.impl;

import org.github.base.entity.QrtzBlobTriggersEntity;
import org.github.base.mapper.IQrtzBlobTriggersMapper;
import org.github.base.service.IQrtzBlobTriggersService;
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
public class QrtzBlobTriggersServiceImpl extends ServiceImpl<IQrtzBlobTriggersMapper, QrtzBlobTriggersEntity> implements IQrtzBlobTriggersService {}
