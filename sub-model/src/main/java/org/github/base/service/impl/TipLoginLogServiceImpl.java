package org.github.base.service.impl;

import org.github.base.entity.TipLoginLogEntity;
import org.github.base.mapper.ITipLoginLogMapper;
import org.github.base.service.ITipLoginLogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 其他-登陆日志表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-14
 */
@Service
public class TipLoginLogServiceImpl extends ServiceImpl<ITipLoginLogMapper, TipLoginLogEntity> implements ITipLoginLogService {}
