package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysMenuMbpEntity;
import org.github.mysql.web.base.mapper.ISysMenuMbpMapper;
import org.github.mysql.web.base.service.ISysMenuMbpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-28
 */
@Service
public class SysMenuMbpServiceImpl extends ServiceImpl<ISysMenuMbpMapper, SysMenuMbpEntity> implements ISysMenuMbpService {}
