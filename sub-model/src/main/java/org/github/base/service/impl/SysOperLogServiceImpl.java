package org.github.base.service.impl;

import org.github.base.entity.SysOperLogEntity;
import org.github.base.mapper.ISysOperLogMapper;
import org.github.base.service.ISysOperLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<ISysOperLogMapper, SysOperLogEntity> implements ISysOperLogService {}
