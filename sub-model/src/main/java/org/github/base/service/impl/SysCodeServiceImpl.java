package org.github.base.service.impl;

import org.github.base.entity.SysCodeEntity;
import org.github.base.mapper.ISysCodeMapper;
import org.github.base.service.ISysCodeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统-编码表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-14
 */
@Service
public class SysCodeServiceImpl extends ServiceImpl<ISysCodeMapper, SysCodeEntity> implements ISysCodeService {}
