package org.github.base.service.impl;

import org.github.base.entity.TipOptLogEntity;
import org.github.base.mapper.ITipOptLogMapper;
import org.github.base.service.ITipOptLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * tip_opt_log_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-07
 */
@Service
public class TipOptLogServiceImpl extends ServiceImpl<ITipOptLogMapper, TipOptLogEntity> implements ITipOptLogService {}
