package org.github.base.service.impl;

import org.github.base.entity.SysMenuEntity;
import org.github.base.mapper.SysMenuMapper;
import org.github.base.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_menu_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-06
 */
@Service
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements ISysMenuService {}
