package org.github.base.service.impl;

import org.github.base.entity.SysOrgEntity;
import org.github.base.mapper.ISysOrgMapper;
import org.github.base.service.ISysOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_org_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-02-15
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<ISysOrgMapper, SysOrgEntity> implements ISysOrgService {}
