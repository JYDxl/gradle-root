package org.github.base.service.impl;

import org.github.base.entity.TipLoginLogEntity;
import org.github.base.mapper.ITipLoginLogMapper;
import org.github.base.service.ITipLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * tip_login_log_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-24
 */
@Service
public class TipLoginLogServiceImpl extends ServiceImpl<ITipLoginLogMapper, TipLoginLogEntity> implements ITipLoginLogService {}
