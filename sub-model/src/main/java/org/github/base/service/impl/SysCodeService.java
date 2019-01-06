package org.github.base.service.impl;

import org.github.base.entity.SysCodeEntity;
import org.github.base.mapper.SysCodeMapper;
import org.github.base.service.ISysCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_code_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-06
 */
@Service
public class SysCodeService extends ServiceImpl<SysCodeMapper, SysCodeEntity> implements ISysCodeService {}
