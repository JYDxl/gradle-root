package org.github.base.service.impl;

import org.github.base.entity.QrtzJobDetailsEntity;
import org.github.base.mapper.IQrtzJobDetailsMapper;
import org.github.base.service.IQrtzJobDetailsService;
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
public class QrtzJobDetailsServiceImpl extends ServiceImpl<IQrtzJobDetailsMapper, QrtzJobDetailsEntity> implements IQrtzJobDetailsService {}
