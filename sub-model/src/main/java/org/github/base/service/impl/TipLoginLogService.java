package org.github.base.service.impl;

import org.github.base.entity.TipLoginLogEntity;
import org.github.base.mapper.TipLoginLogMapper;
import org.github.base.service.ITipLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * tip_login_log_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-07
 */
@Service
public class TipLoginLogService extends ServiceImpl<TipLoginLogMapper, TipLoginLogEntity> implements ITipLoginLogService {}
