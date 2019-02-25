package org.github.base.service.impl;

import org.github.base.entity.SysCodeEntity;
import org.github.base.mapper.ISysCodeMapper;
import org.github.base.service.ISysCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_code_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-02-25
 */
@Service
public class SysCodeServiceImpl extends ServiceImpl<ISysCodeMapper, SysCodeEntity> implements ISysCodeService {}
