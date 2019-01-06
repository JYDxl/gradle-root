package org.github.base.service.impl;

import org.github.base.entity.SysOrgEntity;
import org.github.base.mapper.SysOrgMapper;
import org.github.base.service.ISysOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_org_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-06
 */
@Service
public class SysOrgService extends ServiceImpl<SysOrgMapper, SysOrgEntity> implements ISysOrgService {}
